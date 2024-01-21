import {Component, OnInit} from '@angular/core';
import {Project} from "../Models/project";
import {ProjectService} from "../services/project.service";

@Component({
  selector: 'app-all',
  templateUrl: './all.component.html',
  styleUrl: './all.component.css'
})
export class AllComponent implements OnInit{

  projects:Array<Project>=[];

  constructor(private projectService:ProjectService) {

  }

  ngOnInit() {
    this.projectService.getProjects().subscribe({
      next:(data) => {
        this.projects=data;
      },
      error: err =>{
        console.log(err);
      }
    });
  }

  handleDelete(project: Project) {
    if(confirm("Etes vous sure?"))
      this.projectService.deleteProject(project).subscribe({
        next:value => {
          //this.getProducts()
          this.projects=this.projects.filter(pr => pr.id!=project.id);
        }
      })
  }
}
