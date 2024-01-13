package ma.ehei.projectsprint.sprintservice.services;

import ma.ehei.projectsprint.sprintservice.entities.Sprint;

import java.util.List;
import java.util.Optional;

public interface SprintService {
    Optional<Sprint> getSprintById(Integer id);
    List<Sprint> getAll();
    Sprint add(Sprint sprint);
    Sprint update(Integer id, Sprint sprintEdit);
    void delete(Integer id);

}
