import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import {Covid} from 'src/app/models/covidVerification'
import { CovidVerificationService } from 'src/app/services/covid-verification.service';


@Component({
  selector: 'app-covid-verification',
  templateUrl: './covid-verification.component.html',
  styleUrls: ['./covid-verification.component.css']
})
export class CovidVerificationComponent implements OnInit {

  constructor(private covidService: CovidVerificationService) { }

  ngOnInit(): void {
  }

  addCovid(input : any){
    console.log(input)
    this.covidService.addCovid(input)
      .subscribe(
        res => {
          console.log(res);
          document.getElementById("card-body")!.style.display = "none";
        },
        err => console.log(err)
      )
  }

}
