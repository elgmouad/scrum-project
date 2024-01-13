package ma.ehei.projectsprint.projectservice.web;

import ma.ehei.projectsprint.projectservice.entities.Project;
import ma.ehei.projectsprint.projectservice.repository.ProjectRepository;
import ma.ehei.projectsprint.projectservice.services.ProjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/projects")
public class ProjectRestController {
    @Autowired
    private ProjectServices projectServices;

    public ProjectRestController(ProjectServices projectServices) {
        this.projectServices = projectServices;
    }

    @GetMapping
    public List<Project> getAll(){
        return projectServices.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> get(@PathVariable Integer id){
        try{
            Project project = projectServices.getProjectById(id).get();
            return new ResponseEntity<Project>(project, HttpStatus.OK);
        }catch (NoSuchElementException noSuchElementException){
            return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public Project add(@RequestBody Project project){
        return projectServices.add(project);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Project project, @PathVariable Integer id){
        try{
            projectServices.update(id,project);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException noSuchElementException){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        projectServices.delete(id);
    }


}
