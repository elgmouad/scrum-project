import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path:"home", loadChildren: () => import("./home/home.module").then(m => m.HomeModule)},
  {path:"sprints", loadChildren: () => import("./sprints/sprints.module").then(m => m.SprintsModule)},
  {path:"projects",loadChildren: () => import("./projects/projects.module").then(m => m.ProjectsModule)}//lazzy loading.
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
