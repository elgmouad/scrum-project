package ma.ehei.projectsprint.sprintservice.services;

import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.NoArgsConstructor;
import ma.ehei.projectsprint.sprintservice.Exception.SprintNotFoundException;
import ma.ehei.projectsprint.sprintservice.entities.Sprint;
import ma.ehei.projectsprint.sprintservice.repository.SprintRepository;
import ma.ehei.projectsprint.sprintservice.services.SprintService;
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
public class SprintServicesImpl implements SprintService {

    @Autowired
    private SprintRepository sprintRepository;

    public SprintServicesImpl(SprintRepository sprintRepository){
        this.sprintRepository = sprintRepository;
    }
    @Override
    public Optional<Sprint> getSprintById(Integer id) {
        Optional<Sprint> Sprint = sprintRepository.findById(id);
        if (!Sprint.isPresent()) {
            throw new SprintNotFoundException(id);
        } else {
            return sprintRepository.findById(id);
        }
    }

    @Override
    public List<Sprint> getAll() {
        return sprintRepository.findAll();
    }

    @Override
    public Sprint add(Sprint sprint) {
        return sprintRepository.save(sprint);
    }

    @Override
    public Sprint update(Integer id, Sprint SprintEdit) {
        Optional<Sprint> Sprint = getSprintById(id);

        if (!Sprint.isPresent()) {
            throw new SprintNotFoundException(id);
        } else {
            sprintRepository.findById(id);
        }
        return sprintRepository.save(SprintEdit);

//        if (Objects.nonNull(SprintEdit.getLibelle()) && !"".equalsIgnoreCase(SprintEdit.getLibelle())){
//            Sprint.setLibelle(SprintEdit.getLibelle());
//        }
//
//        if (Objects.nonNull(SprintEdit.getDescription()) && SprintEdit.getDescription() !=null){
//            Sprint.setDescription(SprintEdit.getDescription());
//        }
//
//        if (Objects.nonNull(SprintEdit.getSprintDays()) && SprintEdit.getSprintDays() !=null ){
//            Sprint.setSprintDays(SprintEdit.getSprintDays());
//        }
//
//        if (Objects.nonNull(SprintEdit.getDateDebut()) && SprintEdit.getDateDebut() != null){
//            Sprint.setDateDebut(SprintEdit.getDateDebut());
//        }
//        return SprintRepository.save(Sprint);
    }

    @Override
    public void delete(Integer id) {
        Optional<Sprint> SprintOptional = sprintRepository.findById(id);
        if(!SprintOptional.isPresent()){
            throw new SprintNotFoundException(id);
        }else{
            sprintRepository.deleteById(id);
        }
    }

}
