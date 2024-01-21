import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SideNarComponent } from './side-nar.component';

describe('SideNarComponent', () => {
  let component: SideNarComponent;
  let fixture: ComponentFixture<SideNarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SideNarComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SideNarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
