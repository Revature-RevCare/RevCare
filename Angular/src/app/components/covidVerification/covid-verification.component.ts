import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import {Covid} from 'src/app/model/covidVerification'


@Component({
  selector: 'app-covid-verification',
  templateUrl: './covid-verification.component.html',
  styleUrls: ['./covid-verification.component.css']
})
export class CovidVerificationComponent implements OnInit {

  constructor(private router: Router) { }

  covidResults: Covid | any;

  ngOnInit(): void {
  }

  onSubmit(covidInfo: NgForm){
    console.log(covidInfo);
    const covidResults = new Covid(covidInfo.value.covidStatus, covidInfo.value.vaccinationStatus);
  }

}
