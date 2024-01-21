import { Component } from '@angular/core';
import {Project} from "../Models/project";
import {ProjectService} from "../services/project.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrl: './add.component.css'
})
export class AddComponent {

  project: Project;

  constructor(private projectsService: ProjectService,
              private router:Router) {
    this.project = new Project();
  }

  add() {
    this.projectsService.saveProject(this.project).subscribe({
      next :()=>{
        this.router.navigateByUrl("/projects")
      },
      error :() =>{
        alert("hey");
      },
      complete :()=>{
      }
    });
  }
}
