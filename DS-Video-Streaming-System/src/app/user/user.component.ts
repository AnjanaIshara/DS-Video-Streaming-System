import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {
  cards=[]
  arr=[];
  
  constructor() { this.arr=Object.values(history.state);
    console.log(this.arr[2]);
    this.cards=this.arr[2];}

  ngOnInit(): void {
   
    //console.log(this.cards);
   // console.log(this.obj["a"]);
   //console.log(Object.keys(this.cards));
   

    console.log(this.cards);
   
  }

  title = 'My Suggestions';

  gridColumns = 6;

  toggleGridColumns() {
    this.gridColumns = this.gridColumns === 6 ? 5 : 6;
  }

}
