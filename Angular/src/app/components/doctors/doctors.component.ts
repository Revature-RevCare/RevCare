import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/userModel';
import { DnnService } from 'src/app/services/dnn.service';
import { patientForm } from 'src/app/models/patientDiagnos';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { DiagnosisService } from 'src/app/services/diagnosis.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-doctors',
  templateUrl: './doctors.component.html',
  styleUrls: ['./doctors.component.css']
})
export class DoctorsComponent implements OnInit {

  public editDiagnosis!: patientForm;

  name: string = "Doctor Dan";

  user: User = {
    user_id: 1,
    username: "Dan555",
    first_name: "Robert",
    last: "Campbell",
    title: "Doctor",
    email: "dr.campbell@gmail.com",
    password: "thispassword",
    phone_number: "123-456-7890"
  }

  activeD: patientForm[] = [];

  constructor(private dnnService: DnnService, private tokenService: TokenStorageService, private diagnosisService: DiagnosisService) { 
    this.user = tokenService.getUser();
    console.log(this.user);
  }

  ngOnInit(): void {
    this.activeDiagnosis();
  }

  click(diagnosis: patientForm) {
    this.editDiagnosis = diagnosis;
    console.log("doctor click");
  }

  activeDiagnosis() {
    this.dnnService.getByConfirm()
      .subscribe(
        resp => {
          this.activeD = resp;
          console.log(this.activeD);
        },
        error => console.log(error)
      )
  }

  list1: boolean = false;
  list2: boolean = false;
  list3: boolean = false;

  clickEventOne(){
    this.list1 = !this.list1;
    this.list2 = false;
    this.list3 = false;
  }
  clickEventTwo(){
    this.list2 = !this.list2;
    this.list1 = false;
    this.list3 = false;
  }
  clickEventThree(){
    this.list3 = !this.list3;
    this.list1 = false;
    this.list2 = false;
  }

  public onUpdateDiagnosis(editForm:NgForm): void {
    let doctor = this.tokenService.getUser();
    let pform:string = `{
      "id":${editForm.value.id},
      "fname":"${editForm.value.first_name}",
      "lname":"${editForm.value.last_name}",
      "patient_age":"${editForm.value.age}",
      "complaint":"${editForm.value.patient_complaint}",
      "symptoms":"${editForm.value.patient_symptoms}",
      "med_history":"${editForm.value.medical_history}",
      "fam_history":"${editForm.value.family_history}",
      "allergies":"${editForm.value.patient_allergies}",
      "current_meds":"${editForm.value.current_medical}",
      "patient_weight":${editForm.value.weight},
      "patient_height":${editForm.value.height},
      "patient_temp":${editForm.value.temp},
      "blood_pressure_high":${editForm.value.high},
      "blood_pressure_low":${editForm.value.low},
      "pulse":${editForm.value.patient_pulse},
      "doctor_verification":${true},
      "diagnosis_text":"${editForm.value.diagnosis}",
      "covid_id":${editForm.value.covidId},
      "nurse_id":${editForm.value.nurseId},
      "doctor_id":${doctor.id}
      }`;
      console.log(pform);

    this.diagnosisService.updatePatientDiagnosis(pform).subscribe(
      (response: patientForm) => {
        console.log(response);
        this.activeDiagnosis();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }



}
