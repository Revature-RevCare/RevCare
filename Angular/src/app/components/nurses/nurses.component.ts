import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/userModel';
import { DnnService } from 'src/app/services/dnn.service';
import { patientForm } from 'src/app/models/patientDiagnos';

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
  
  constructor(private dnnService: DnnService) { }

  ngOnInit(): void {
    this.activeDiagnosis();
  }

  click() {
    console.log(this.alldiagnosis);
  }

  activeDiagnosis() {
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
