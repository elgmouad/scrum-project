package ma.ehei.projectsprint.projectservice.services;

import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.NoArgsConstructor;
import ma.ehei.projectsprint.projectservice.Exception.ProjectNotFoundException;
import ma.ehei.projectsprint.projectservice.entities.Project;
import ma.ehei.projectsprint.projectservice.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@NoArgsConstructor
@Builder
@Transactional
public class ProjectServicesImpl implements ProjectServices {

    @Autowired
    private ProjectRepository projectRepository;

    public ProjectServicesImpl(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }
    @Override
    public Optional<Project> getProjectById(Integer id) {
        Optional<Project> project = projectRepository.findById(id);
        if (!project.isPresent()) {
            throw new ProjectNotFoundException(id);
        } else {
            return projectRepository.findById(id);
        }
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project add(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project update(Integer id, Project projectEdit) {
        Optional<Project> project = getProjectById(id);

        if (!project.isPresent()) {
            throw new ProjectNotFoundException(id);
        } else {
            projectRepository.findById(id);
        }
        return projectRepository.save(projectEdit);

//        if (Objects.nonNull(projectEdit.getLibelle()) && !"".equalsIgnoreCase(projectEdit.getLibelle())){
//            project.setLibelle(projectEdit.getLibelle());
//        }
//
//        if (Objects.nonNull(projectEdit.getDescription()) && projectEdit.getDescription() !=null){
//            project.setDescription(projectEdit.getDescription());
//        }
//
//        if (Objects.nonNull(projectEdit.getSprintDays()) && projectEdit.getSprintDays() !=null ){
//            project.setSprintDays(projectEdit.getSprintDays());
//        }
//
//        if (Objects.nonNull(projectEdit.getDateDebut()) && projectEdit.getDateDebut() != null){
//            project.setDateDebut(projectEdit.getDateDebut());
//        }
//        return projectRepository.save(project);
    }

    @Override
    public void delete(Integer id) {
        Optional<Project> projectOptional = projectRepository.findById(id);
        if(!projectOptional.isPresent()){
            throw new ProjectNotFoundException(id);
        }else{
            projectRepository.deleteById(id);
        }
    }

}
