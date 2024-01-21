package ma.ehei.projectsprint.sprintservice.web;


import ma.ehei.projectsprint.sprintservice.Project.ProjectRestClient;
import ma.ehei.projectsprint.sprintservice.entities.Sprint;
import ma.ehei.projectsprint.sprintservice.model.Project;
import ma.ehei.projectsprint.sprintservice.services.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/sprints")
public class SprintRestController {
    private SprintService sprintService;
    private ProjectRestClient projectRestClient;

    public SprintRestController(SprintService sprintService, ProjectRestClient projectRestClient) {
        this.sprintService = sprintService;
        this.projectRestClient = projectRestClient;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Sprint>> get(){
        List<Sprint> sprints= sprintService.getAll();
        sprints.forEach(prj -> {
            prj.setProject(projectRestClient.getProjectById(prj.getProjectId()));
        });
        return ResponseEntity.ok().body(sprints);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<Sprint>> get(@PathVariable Integer id){
            Sprint sprint = sprintService.getSprintById(id).get();
            Project project = projectRestClient.getProjectById(sprint.getProjectId());
            sprint.setProject(project);
            return ResponseEntity.ok().body(Optional.of(sprint));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Sprint> add(@RequestBody Sprint sprint){
        Sprint sprint1 = sprintService.add(sprint);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sprint1.getId()).toUri();
        return ResponseEntity.created(uri).body(sprint1);
        //return sprintService.add(sprint);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Sprint> update(@RequestBody Sprint sprint,
                                          @PathVariable Integer id){
        return ResponseEntity.ok().body(sprintService.update(id,sprint));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        sprintService.delete(id);
    }


}
