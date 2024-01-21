import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { SideNarComponent } from './side-nar/side-nar.component';
import { FooterComponent } from './footer/footer.component';
import { TopNavComponent } from './top-nav/top-nav.component';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SharedRoutingModule } from './shared-routing.module';

@NgModule({
  declarations: [
    SideNarComponent,
    FooterComponent,
    TopNavComponent
  ],
  exports :[
    SideNarComponent,
    FooterComponent,
    TopNavComponent
  ],
  imports: [
    RouterModule,//pour fait la navigation entre le module.
    BrowserModule,//pour affiicher le nav
    //SharedRoutingModule//si vous avez the rout sur la clas shared-router.module.ts

  ]
})
export class SharedModule { }
