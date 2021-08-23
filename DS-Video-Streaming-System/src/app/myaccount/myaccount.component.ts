import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import {FormGroup, FormControl} from '@angular/forms';
import {forkJoin} from 'rxjs';
@Component({
  selector: 'app-myaccount',
  templateUrl: './myaccount.component.html',
  styleUrls: ['./myaccount.component.css']
})
export class MyaccountComponent implements OnInit {
  InputJsonObj: any;
  registerPromise: any;
  preferencePromise: any;
  boolArr=[false,false,false]
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

 
  constructor(private route: ActivatedRoute,private http: HttpClient) { }

  ngOnInit(): void {
    
    this.getProfileInfo(localStorage.getItem('username')).subscribe(data=>{
      console.log(data["usercreds"]["username"]);
      if(data["choices"].indexOf("comedy")!=-1){
        this.boolArr[0]=true;
      }
      if(data["choices"].indexOf("action")!=-1){
        this.boolArr[1]=true;
      }
      if(data["choices"].indexOf("horror")!=-1){
        this.boolArr[2]=true;
      }
      console.log(data["choices"].indexOf("comedy"));
      this.profileForm.setValue({
        username:data["usercreds"]["username"],
        password:data["usercreds"]["password"],
        action:this.boolArr[1],
        comedy:this.boolArr[0],
        horror:this.boolArr[2],
      })
     
    })

  }

  getProfileInfo(id:any):Observable<any>{
    return this.http.get<any>(`http://localhost:8989/api/Movie-Login/getprofiledetails/${id}`);
  }
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
}
