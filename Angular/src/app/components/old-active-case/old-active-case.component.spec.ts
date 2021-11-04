import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OldActiveCaseComponent } from './old-active-case.component';

describe('OldActiveCaseComponent', () => {
  let component: OldActiveCaseComponent;
  let fixture: ComponentFixture<OldActiveCaseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OldActiveCaseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OldActiveCaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
