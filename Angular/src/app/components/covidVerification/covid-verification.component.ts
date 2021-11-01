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

  addPost(input : any){
    console.log(input)
    this.postService.addPost(input)
      .subscribe(
        res => {
          console.log(res)
          window.location.reload();
        },
        err => console.log(err)
      )
  }

  onSubmit(covidInfo: NgForm){
    console.log(covidInfo.value);

    const covidResults = new Covid(covidInfo.value.covidStatus, covidInfo.value.vaccinationStatus);
    document.getElementById("formPage")!.style.display = "none";
  }

  openForm(){
    document.getElementById("formPage")!.style.display = "block";
  }
  

}
