import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/userModel';
import { DnnService } from 'src/app/services/dnn.service';
import { patientForm } from 'src/app/models/patientDiagnos';
import { HttpHeaders } from '@angular/common/http';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-nurses',
  templateUrl: './nurses.component.html',
  styleUrls: ['./nurses.component.css']
})
export class NursesComponent implements OnInit {

  user: User = {
    user_id: 1,
    first_name: "Dan",
    last_name: "Felleman",
    title: "Nurse",
    email: "nurse.danl@gmail.com",
    password: "password",
    phone_number: "103-456-7890"
  }

  alldiagnosis: patientForm[] = [];

  // jwtToken = sessionStorage.getToken('auth-user');

  // headers = new HttpHeaders().set('content-type', 'application/json')
  //                            .set('Access-Control-Allow-Origin', '*')
  //                            .set('authorization', this.jwtToken);
;
  
  constructor(private dnnService: DnnService, private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    this.activeDiagnosis();
    this.tokenStorage.getToken(); 
    this.tokenStorage.getUser();
  }

  click() {
    console.log(this.alldiagnosis);
  }

  activeDiagnosis() {
    console.log("We are in the area where we should start accessing the database.")
    this.dnnService.getDiagnosis()
      .subscribe(
        resp => {
          this.alldiagnosis = resp;
          console.log(this.alldiagnosis);
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

}
