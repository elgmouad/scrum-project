package ma.ehei.projectsprint.sprintservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

@Getter @Setter @ToString
public class Project {
    private Integer id;
    private String libelle;
    private String description;
    private Integer sprintDays;
    private LocalDate dateDebut;
}
