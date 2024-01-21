import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Project} from "../../projects/Models/project";
import {Sprint} from "../Models/sprint";

@Injectable({
  providedIn: 'root'
})
export class SprintService {

  constructor(private http:HttpClient ) { }

  url:string="http://localhost:8888/SPRINT-SERVICE/sprints";

  public getSprints():Observable<Array<Sprint>>{
    return this.http.get<Array<Sprint>>(this.url);
  }
  /*
  public checkProject(project:Project):Observable<Project>{
    return this.http.put<Project>(`http://localhost:8888/PROJECT-SERVICE/projects/${project.id}`,
      {checked:!project.checked});
  }
  */
  public deleteSprint(sprint:Sprint){
    return this.http.delete<Sprint>(this.url+"/"+sprint.id);
  }

  saveSprint(sprint: Sprint):Observable<Sprint> {
    return this.http.post<Sprint>(this.url,sprint);
  }
  public searchSprints(keyword:Number):Observable<Array<Sprint>>{
    return this.http.get<Array<Sprint>>(`this.url/${keyword}`);
  }

}
