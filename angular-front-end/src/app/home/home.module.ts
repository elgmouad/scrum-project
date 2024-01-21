import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AllComponent } from './all/all.component';
import { RouterModule } from '@angular/router';
import { HomeRoutingModule } from './home-routing.module';




@NgModule({
  declarations: [
    AllComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule
  ]
})
export class HomeModule { }
