import { Component, OnInit } from '@angular/core';
import { CovidVerificationService } from 'src/app/services/covid-verification.service';
import { CookieService } from 'ngx-cookie-service'


@Component({
  selector: 'app-diagnosis',
  templateUrl: './diagnosis.component.html',
  styleUrls: ['./diagnosis.component.css']
})
export class DiagnosisComponent implements OnInit {

  constructor(private covidService: CovidVerificationService, private cookieService: CookieService) { }

  ngOnInit(): void {
    document.getElementById("covid")!.style.display = "block";
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
          document.getElementById("covid")!.style.display = "none";
        },
        err => console.log(err)
      )
  }
}
