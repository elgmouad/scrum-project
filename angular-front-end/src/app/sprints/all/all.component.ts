import {Component, OnInit} from '@angular/core';
import {Project} from "../../projects/Models/project";
import {ProjectService} from "../../projects/services/project.service";
import {Sprint} from "../Models/sprint";
import {SprintService} from "../services/sprint.service";

@Component({
  selector: 'app-all',
  templateUrl: './all.component.html',
  styleUrl: './all.component.css'
})
export class AllComponent implements OnInit{

  sprints:Array<Sprint>=[];

  constructor(private sprintService:SprintService) {

  }

  ngOnInit() {
    this.sprintService.getSprints().subscribe({
      next:(data) => {
        this.sprints=data;
      },
      error: err =>{
        console.log(err);
      }
    });
  }

  handleDelete(sprint: Sprint) {
    if(confirm("Etes vous sure?"))
      this.sprintService.deleteSprint(sprint).subscribe({
        next:value => {
          //this.getProducts()
          this.sprints=this.sprints.filter(spr => spr.id!=sprint.id);
        }
      })
  }

}
