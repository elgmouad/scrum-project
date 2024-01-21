import {Project} from "../../projects/Models/project";

export class Sprint {
  id:number=0;
  sprintName:string="";
  sprintGoal:string="";
  dateDebut!:Date;
  dateFin!:Date;
  project!:Project;
  projectID:number=0;
}
