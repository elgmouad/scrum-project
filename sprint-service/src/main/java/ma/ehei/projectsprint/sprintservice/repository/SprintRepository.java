package ma.ehei.projectsprint.sprintservice.repository;

import ma.ehei.projectsprint.sprintservice.entities.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintRepository extends JpaRepository<Sprint,Integer> {
}
