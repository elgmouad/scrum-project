package ma.ehei.projectsprint.sprintservice.Exception;

public class SprintNotFoundException extends RuntimeException{
    public SprintNotFoundException(Integer id){
        super("Could Not Find Sprint whit " +id+ ".");
    }
}
