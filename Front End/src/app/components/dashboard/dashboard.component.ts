import { Component, OnInit, NgZone } from '@angular/core';
import { AuthService } from "../auth.service";
import { Router } from "@angular/router";
import { AngularFirestore } from '@angular/fire/firestore';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
data :any;
Name1:string;
PhoneNumber1:string;
EmailVerified1:boolean;
checking1:boolean;
ParkNo1:number;

  constructor(
    public authService: AuthService,
    public router: Router,
    public ngZone: NgZone,
    private firestore: AngularFirestore,
  ) {}

  Parkings(){
    this.router.navigate(['park-location']);  // define your component where you want to go
}


  ngOnInit() { 
    // this.firestore.collection('users').valueChanges().
    // subscribe(val=>console.log(val));
    this.firestore.collection('users').valueChanges().
    subscribe((val)=>{
      
      for (var x of val){
        if(x["uid"]==localStorage.getItem('xxx')){
          this.Name1=x["displayName"];
          this.PhoneNumber1=x["phoneNumber"];
          this.EmailVerified1=x["emailVerified"];
          this.checking1=x["checking"];
          this.ParkNo1=x["ParkNo"];
        }
        
      }
      
    }
      
      
      
      );
    // console.log(`val is ${localStorage.getItem('xxx')}`)
  }



 



}