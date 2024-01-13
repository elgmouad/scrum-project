package ma.ehei.projectsprint.projectservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class Project {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String libelle;
    private String description;
    private Integer sprintDays;
    private LocalDate dateDebut;

}
