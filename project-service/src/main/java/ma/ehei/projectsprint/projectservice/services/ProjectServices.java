package ma.ehei.projectsprint.projectservice.services;

import ma.ehei.projectsprint.projectservice.entities.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectServices {
    Optional<Project> getProjectById(Integer id);
    List<Project> getAll();
    Project add(Project project);
    Project update(Integer id,Project projectEdit);
    void delete(Integer id);

}
