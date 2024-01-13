package ma.ehei.projectsprint.sprintservice.Project;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ma.ehei.projectsprint.sprintservice.entities.Sprint;
import ma.ehei.projectsprint.sprintservice.model.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "PROJECT-SERVICE")
@RestController
public interface ProjectRestClient {

    @GetMapping("/projects/{id}")
    @CircuitBreaker(name = "projectService",fallbackMethod = "getDefaultProject")
    Project getProjectById(@PathVariable Integer id);
    @GetMapping("/projects")
    @CircuitBreaker(name = "projectService",fallbackMethod = "getAllProjects")
    List<Project> getAll();

    default Project getDefaultProject(Integer id,Exception exception){
        Project project = new Project();
        project.setId(id);
        project.setLibelle("Not Vailable");
        project.setDescription("Not Vailable");
        project.setDateDebut(null);
        project.setSprintDays(0);
        return project;
    }

    default List<Project> getAllProjects(Exception exception){
        return List.of();
    }
}
