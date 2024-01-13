package ma.ehei.projectsprint.projectservice;

import ma.ehei.projectsprint.projectservice.entities.Project;
import ma.ehei.projectsprint.projectservice.repository.ProjectRepository;
import ma.ehei.projectsprint.projectservice.services.ProjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
@EnableConfigurationProperties()
public class ProjectServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProjectServices projectServices){
        return args -> {
            Project project1 = Project.builder()
                    .libelle("ProjetManager")
                    .description("digetalisation de gestion de projet ")
                    .sprintDays(18)
                    .dateDebut(LocalDate.now())
                    .build();
            Project project2 = Project.builder()
                    .libelle("LMS")
                    .description("Learning Management System ")
                    .sprintDays(20)
                    .dateDebut(LocalDate.now())
                    .build();
            projectServices.add(project1);
            projectServices.add(project2);
        };

    }
}
