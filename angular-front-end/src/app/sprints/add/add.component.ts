import {Component, OnInit} from '@angular/core';
import {Project} from "../../projects/Models/project";
import {ProjectService} from "../../projects/services/project.service";
import {Router} from "@angular/router";
import {Sprint} from "../Models/sprint";
import {SprintService} from "../services/sprint.service";
import {Projects} from "@angular/cli/lib/config/workspace-schema";

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrl: './add.component.css'
})
export class AddComponent implements OnInit{

  sprint:Sprint;
  projects:Array<Project>=[];

  constructor(private sprintService: SprintService,
              private projectService:ProjectService,
              private router:Router) {
    this.sprint = new Sprint();
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

  add() {
    this.sprintService.saveSprint(this.sprint).subscribe({
      next :()=>{
        this.router.navigateByUrl("/sprints")
      },
      error :() =>{
        alert("It's Error handling");
      },
      complete :()=>{
      }
    });
  }
}
