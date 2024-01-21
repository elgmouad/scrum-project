import { Component } from '@angular/core';

@Component({
  selector: 'app-side-nar',
  templateUrl: './side-nar.component.html',
  styleUrl: './side-nar.component.css'
})
export class SideNarComponent {

  actions : Array<any> =[
    {title :"Home", "router":"/home", icon:""},
    {title :"Project", "router":"/projects", icon:""},
    {title :"Sprint", "router":"/sprints", icon:""}
  ]
  currentAction :any;


  setCurrentAction(action: any) {
    this.currentAction = action;
  }
  
}
