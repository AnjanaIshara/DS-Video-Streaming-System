import {Component, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {forkJoin} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  InputJsonObj: any;

  constructor(private http: HttpClient,private router: Router) {
  }

  ngOnInit(): void {
  }

  profileForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
  })

  onLogin() {
    this.InputJsonObj = JSON.parse(JSON.stringify(this.profileForm.value));
    console.log(this.InputJsonObj);
    this.http.post('http://localhost:8989/api/Movie-Login/login', this.InputJsonObj, {headers: {'Content-Type': 'application/json'}}).toPromise().then(data => {
      this.router.navigateByUrl('user', { state:data });
    })

  }

}
