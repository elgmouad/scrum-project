package ma.ehei.projectsprint.projectservice.web;

import ma.ehei.projectsprint.projectservice.entities.Project;
import ma.ehei.projectsprint.projectservice.services.ProjectServices;
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
@RequestMapping("/projects")
public class ProjectRest2Controller {
    @Autowired
    private ProjectServices projectServices;

    public ProjectRest2Controller(ProjectServices projectServices) {
        this.projectServices = projectServices;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Project>> get(){
        return ResponseEntity.ok().body(projectServices.getAll());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<?>> get(@PathVariable Integer id){
            //Project project = projectServices.getProjectById(id);
            return ResponseEntity.ok().body(projectServices.getProjectById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Project> add(@RequestBody Project project){
        Project project1 = projectServices.add(project);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(project1.getId()).toUri();
        return ResponseEntity.created(uri).body(project1);
        //return projectServices.add(project);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Project> update(@RequestBody Project project,
                                          @PathVariable Integer id){
        return ResponseEntity.ok().body(projectServices.update(id,project));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        projectServices.delete(id);
    }


}
