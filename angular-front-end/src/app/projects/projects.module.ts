import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProjectsRoutingModule } from './projects-routing.module';
import { AddComponent } from './add/add.component';
import { AllComponent } from './all/all.component';
import { UpdateComponent } from './update/update.component';
import { DeleteComponent } from './delete/delete.component';
import { RouterModule } from '@angular/router';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";


@NgModule({
  declarations: [
    AddComponent,
    AllComponent,
    UpdateComponent,
    DeleteComponent
  ],
  imports: [
    CommonModule,
    ProjectsRoutingModule,
    FormsModule,
    HttpClientModule
  ]
})
export class ProjectsModule { }
