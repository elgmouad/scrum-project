package ma.ehei.projectsprint.sprintservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.ehei.projectsprint.sprintservice.model.Project;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class Sprint implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String sprintName;
    private String sprintGoal;
    private LocalDate dateDebut;
    private Date dateFin;
    @Transient
    private Project project;
    private Integer projectId;
}
