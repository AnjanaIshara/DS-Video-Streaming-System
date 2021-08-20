import {HttpClient} from '@angular/common/http';
import {Component, OnInit} from '@angular/core';
import {forkJoin} from 'rxjs';
import {FormGroup, FormControl} from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  InputJsonObj: any;
  registerPromise: any;
  preferencePromise: any;
  RegisterObj = {
    username: '',
    password: '',
  };
  PreferencesObj = {
    username: '',
    choices: [''],
  }

  profileForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
    action: new FormControl(false),
    comedy: new FormControl(false),
    horror: new FormControl(false),
  });

  onRegister() {
    this.InputJsonObj = JSON.parse(JSON.stringify(this.profileForm.value));
    this.RegisterObj['username'] = this.InputJsonObj['username'];
    this.RegisterObj['password'] = this.InputJsonObj['password'];
    this.PreferencesObj['username'] = this.InputJsonObj['username'];
    if (this.InputJsonObj['action'] == true) {
      this.PreferencesObj.choices.push('action');
    }
    if (this.InputJsonObj['comedy'] == true) {
      this.PreferencesObj.choices.push('comedy');
    }
    if (this.InputJsonObj['horror'] == true) {
      this.PreferencesObj.choices.push('horror');
    }
    this.PreferencesObj.choices.reverse();
    this.PreferencesObj.choices.pop();

    // console.log(this.RegisterObj);
    // console.log(this.PreferencesObj);
    // this.registerPromise=this.http.post('http://localhost:8081/signup',this.RegisterObj).toPromise();
    // this.preferencePromise=this.http.post('http://localhost:8082/preferences',this.PreferencesObj).toPromise().then(data=>{
    //   console.log("response from preferences==>",data);
    // })
    forkJoin([
      this.http.post('http://localhost:8989/api/Movie-Login/signup', this.RegisterObj, {headers: {'Content-Type': 'application/json'}}),
      this.http.post('http://localhost:8989/api/Movie-Preferences/preferences', this.PreferencesObj, {headers: {'Content-Type': 'application/json'}})
    ]).subscribe(data => {
      console.log("signup response==>", data[0]),
        console.log("Preferences response==>", data[1])
    })


  }

  // onCheckChange(choice:String){
  //   console.log(choice);
  // }
  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
  }

}
