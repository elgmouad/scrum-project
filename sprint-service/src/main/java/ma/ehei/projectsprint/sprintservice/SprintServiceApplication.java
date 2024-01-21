package ma.ehei.projectsprint.sprintservice;

import ma.ehei.projectsprint.sprintservice.entities.Sprint;
import ma.ehei.projectsprint.sprintservice.services.SprintService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class SprintServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprintServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(SprintService sprintService){
        return args -> {
            Sprint sprint1 = Sprint.builder()
                    .id(1)
                    .sprintName("crud management Project number 1")
                    .sprintGoal("CRUD ( Project, Sprint) Classes  ")
                    .dateDebut(LocalDate.now().plusDays(1))
                    .dateFin(LocalDate.now().plusWeeks(2))
                    .projectId(1)
                    .build();
            Sprint sprint2 = Sprint.builder()
                    .id(2)
                    .sprintName("crud management Project number 2")
                    .sprintGoal("CRUD ( UserStory, Developper ) Classes  ")
                    .dateDebut(LocalDate.now().plusDays(1))
                    .dateFin(LocalDate.now().plusWeeks(3))
                    .projectId(1)
                    .build();
            Sprint sprint3 = Sprint.builder()
                    .id(3)
                    .sprintName("crud management LMS number 1")
                    .sprintGoal("CRUD ( Science ) Classes  ")
                    .dateDebut(LocalDate.now().plusDays(1))
                    .dateFin(LocalDate.now().plusWeeks(1))
                    .projectId(2)
                    .build();
            sprintService.add(sprint1);
            sprintService.add(sprint2);
            sprintService.add(sprint3);

        };

    }
}
