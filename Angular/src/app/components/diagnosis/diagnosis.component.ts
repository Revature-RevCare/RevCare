import { Component, OnInit } from '@angular/core';
import { CovidVerificationService } from 'src/app/services/covid-verification.service';

@Component({
  selector: 'app-diagnosis',
  templateUrl: './diagnosis.component.html',
  styleUrls: ['./diagnosis.component.css']
})
export class DiagnosisComponent implements OnInit {

  constructor(private covidService: CovidVerificationService) { }

  ngOnInit(): void {
    document.getElementById("covid")!.style.display = "block";
  }

  addCovid(input : any){
    console.log(input)
    this.covidService.addCovid(input)
      .subscribe(
        res => {
          console.log(res);
          document.getElementById("covid")!.style.display = "none";
        },
        err => console.log(err)
      )
  }
}
