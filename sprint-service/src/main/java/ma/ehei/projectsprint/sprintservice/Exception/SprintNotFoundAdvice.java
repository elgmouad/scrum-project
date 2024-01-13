package ma.ehei.projectsprint.sprintservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class SprintNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(SprintNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String projectNotFoundHandler(SprintNotFoundException ex){
        return ex.getMessage();
    }
}