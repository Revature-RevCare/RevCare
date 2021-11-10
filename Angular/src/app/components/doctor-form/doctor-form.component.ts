import { Component, OnInit } from '@angular/core';
import { patientForm } from 'src/app/models/patientDiagnos';

@Component({
  selector: 'app-doctor-form',
  templateUrl: './doctor-form.component.html',
  styleUrls: ['./doctor-form.component.css']
})
export class DoctorFormComponent implements OnInit {
  private updateForm!: patientForm;

  constructor() { }

  ngOnInit(): void {
  }

}
