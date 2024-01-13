package ma.ehei.projectsprint.projectservice.Exception;

import ma.ehei.projectsprint.projectservice.entities.Project;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ProjectNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ProjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String projectNotFoundHandler(ProjectNotFoundException ex){
        return ex.getMessage();
    }
}