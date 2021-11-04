import { Component, ElementRef, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { CovidVerificationService } from 'src/app/services/covid-verification.service';
import { CookieService } from 'ngx-cookie-service'
import { TokenStorageService } from 'src/app/services/token-storage.service';

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

  
    
  constructor(private covidService: CovidVerificationService, private cookieService: CookieService, private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    openForm();
    this.tokenStorage.getToken(); 
    this.tokenStorage.getUser().token;
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
