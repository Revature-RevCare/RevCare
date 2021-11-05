import { Component, ElementRef, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { CovidVerificationService } from 'src/app/services/covid-verification.service';
import { CookieService } from 'ngx-cookie-service'
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { NgForm } from '@angular/forms';
import {patientForm} from 'src/app/models/patientDiagnos'
import { DiagnosisService } from 'src/app/services/diagnosis.service';

function openForm(){
  document.getElementById("myForm")!.style.display = "block";
  document.getElementById("body")!.style.filter = "blur(4px)";
}

function closeForm(){
  document.getElementById("myForm")!.style.display = "none";
  document.getElementById("body")!.style.filter = "blur(0px)";
}


@Component({
  selector: 'app-diagnosis',
  templateUrl: './diagnosis.component.html',
  styleUrls: ['./diagnosis.component.css']
})
export class DiagnosisComponent implements OnInit {

  
    
  constructor(private covidService: CovidVerificationService, private cookieService: CookieService, private tokenStorage: TokenStorageService, private diagnosisService:DiagnosisService) { }

  ngOnInit(): void {
    openForm();
    this.tokenStorage.getToken(); 
    this.tokenStorage.getUser().token;
  }
  
  /*interface patientForm {
    id: number;
    fname: string;
    lname: string;
    patient_age: number;
    complaint: string;
    symptoms: string;
    med_history: string;
    fam_history: string;
    allergies: string;
    current_meds: string;
    current_date: string;
    patient_weight: number;
    patient_height: number;
    patient_temp: number;
    blood_pressure_high: number;
    blood_pressure_low: number;
    pulse: number;
    doctor_verification: boolean;
    diagnosis_text: string;
    covid_id: Covid;
    nurse_id: number;
    doctor_id: number;
 }*/
 
  onSubmit(f:NgForm){
    let covidForm = JSON.parse(JSON.parse(this.cookieService.get('covidInfo')));
    let nurse = this.tokenStorage.getUser();
    let pform:string = `{
      "fname":"${f.value.fname}",
      "lname":"${f.value.lname}",
      "patient_age":"${f.value.age}",
      "complaint":"${f.value.discomfort}",
      "symptoms":"${f.value.symptoms}",
      "med_history":"${f.value.mhistory}",
      "fam_history":"${f.value.fhistory}",
      "allergies":"${f.value.allergies}",
      "current_meds":"${f.value.meds}",
      "current_date":${f.value.date},
      "patient_weight":${f.value.weight},
      "patient_height":${f.value.height},
      "patient_temp":${f.value.temp},
      "blood_pressure_high":${f.value.bphigh},
      "blood_pressure_low":${f.value.bplow},
      "pulse":${f.value.pulse},
      "doctor_verification":${false},
      "diagnosis_text":"${f.value.diagnosis}",
      "covid_id":${covidForm.covidId},
      "nurse_id":${nurse.id},
      "doctor_id":-1
      }`;
    this.diagnosisService.addPatientDiagnosis(pform).subscribe(
      (Response)=>{
        alert("diagnosis successfully submitted for doctor to review.");
      },
      (error)=>{
        alert(error);
      }
    )
  }


  addCovid(input : any){
    console.log(input)
    this.covidService.addCovid(input)
      .subscribe(
        res => {
          let cookieValue:string=`"{\\"covidId\\":${res.covidId},\\"covidStatus\\":\\"${res.covidStatus}\\",\\"vaccinationStatus\\":\\"${res.vaccinationStatus}}"`;
          this.cookieService.set('covidInfo', cookieValue);
          console.log(cookieValue)
          console.log(res);
          closeForm()
                },
        err => console.log(err)
      )
  }
}
