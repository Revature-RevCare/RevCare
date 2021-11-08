import { Component, ElementRef, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { CovidVerificationService } from 'src/app/services/covid-verification.service';
import { CookieService } from 'ngx-cookie-service'

function openForm(){ //created this function to display our form as a pop-up
  document.getElementById("myForm")!.style.display = "block"; //used block keyword to let HTML know to display our form
  document.getElementById("body")!.style.filter = "blur(4px)"; //blur will blur the background content to make it look nicer
  document.getElementById("body")!.style.pointerEvents = "none"; //pointerEvents to none will not let the mouse click anything else besides the form
}

function closeForm(){ //with this function we will hide away or "close" our form
  document.getElementById("myForm")!.style.display = "none"; //by stating none this will hide our form once finished
  document.getElementById("body")!.style.filter = "blur(0px)"; //blur set to 0px will bring back the contents to a better focus
  document.getElementById("body")!.style.pointerEvents = "all"; //pointerEvents set to all will allow all mouse event to happen again
}


@Component({
  selector: 'app-diagnosis',
  templateUrl: './diagnosis.component.html',
  styleUrls: ['./diagnosis.component.css']
})
export class DiagnosisComponent implements OnInit {


    
  constructor(private covidService: CovidVerificationService, private cookieService: CookieService) { }

  ngOnInit(): void {
   openForm();
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
