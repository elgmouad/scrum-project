package ma.ehei.projectsprint.projectservice.Exception;

public class ProjectNotFoundException extends RuntimeException{
    public ProjectNotFoundException(Integer id){
        super("Could Not Find Project whit " +id+ ".");
    }
}
