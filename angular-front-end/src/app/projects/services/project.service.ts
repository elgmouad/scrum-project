import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Project } from '../Models/project';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  constructor(private http:HttpClient ) { }

  url:string="http://localhost:8888/PROJECT-SERVICE/projects";

  public getProjects():Observable<Array<Project>>{
    return this.http.get<Array<Project>>(this.url);
  }
  /*
  public checkProject(project:Project):Observable<Project>{
    return this.http.put<Project>(`http://localhost:8888/PROJECT-SERVICE/projects/${project.id}`,
      {checked:!project.checked});
  }
  */
  public deleteProject(project:Project){
    return this.http.delete<Project>(this.url+"/"+project.id);
  }

  saveProject(project: Project):Observable<Project> {
    return this.http.post<Project>(this.url,project);
  }
  // public searchProjects(keyword:Number):Observable<Array<Project>>{
  //   return this.http.get<Array<Project>>(`this.url/${keyword}`);
  // }
}
