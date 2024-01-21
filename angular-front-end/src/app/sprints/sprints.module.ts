import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SprintsRoutingModule } from './sprints-routing.module';
import { AddComponent } from './add/add.component';
import { AllComponent } from './all/all.component';
import { UpdateComponent } from './update/update.component';
import { DeleteComponent } from './delete/delete.component';
import { RouterModule } from '@angular/router';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    AddComponent,
    AllComponent,
    UpdateComponent,
    DeleteComponent
  ],
  imports: [
    CommonModule,
    SprintsRoutingModule,
    ReactiveFormsModule,
    FormsModule
//necessaire pour appliquer les routes qui vous avez dans la liste des route
  ]
})
export class SprintsModule { }
