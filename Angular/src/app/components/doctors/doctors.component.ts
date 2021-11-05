import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/userModel';
import { DnnService } from 'src/app/services/dnn.service';
import { patientForm } from 'src/app/models/patientDiagnos';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-doctors',
  templateUrl: './doctors.component.html',
  styleUrls: ['./doctors.component.css']
})
export class DoctorsComponent implements OnInit {

  name: string = "Doctor Dan";

  user: User = {
    user_id: 1,
    username: "Dan555",
    first_name: "Robert",
    last_name: "Campbell",
    title: "Doctor",
    email: "dr.campbell@gmail.com",
    password: "thispassword",
    phone_number: "123-456-7890"
  }

  activeD: patientForm[] = [];

  constructor(private dnnService: DnnService, private tokenService: TokenStorageService) {
    this.user = this.tokenService.getUser();
    console.log(this.user);
   }

  ngOnInit(): void {
    this.activeDiagnosis();
  }

  click() {
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

}
