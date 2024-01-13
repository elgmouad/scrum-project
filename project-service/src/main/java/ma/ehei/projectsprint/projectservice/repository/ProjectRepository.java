package ma.ehei.projectsprint.projectservice.repository;

import ma.ehei.projectsprint.projectservice.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
}
