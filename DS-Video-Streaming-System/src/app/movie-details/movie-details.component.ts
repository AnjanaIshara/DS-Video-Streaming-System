import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {HttpClient} from '@angular/common/http';
import { Reviews } from '../review';
import { Observable } from 'rxjs';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css','movie-details.component.scss']
})
export class MovieDetailsComponent implements OnInit {
  moviename:any;
  movieurl:any;
  moviereviews:any;
  username:any;
  usercomment:any;
  rating = 0;

  jsonObj:any;
  reviewForm=new FormGroup({
    comments: new FormControl(''),
    moviename: new FormControl(''),
    ratings: new FormControl(''),
    username: new FormControl('')
  })

  constructor(private route: ActivatedRoute,private http: HttpClient) { }
  
  ngOnInit(): void {
    this.moviename=this.route.snapshot.paramMap.get('movie_name');
    console.log(this.moviename);
    this.username=localStorage.getItem('username');
    this.getMovieReviews(this.moviename).subscribe(data=>
      {
        this.movieurl=Object.values(data)[0];
        this.moviereviews=Object.values(data)[1];
        // console.log(`movie URL>>> ${this.movieurl}`)
        // console.log(`movie REVIEWS>>> ${this.moviereviews[0]["username"]}`)
      }
      );
  }
  getMovieReviews(id:any):Observable<Reviews[]>{
    return this.http.get<Reviews[]>(`http://localhost:8989/api/Movie-Reviews/moviereview/${id}`);
  }
  
  title = 'Movie Details';

  gridColumns = 5;

  toggleGridColumns() {
    this.gridColumns = this.gridColumns === 5 ? 6 : 5;
  }

  onSubmit(): void {
    // Process checkout data here
    this.reviewForm.setValue({
      comments:this.usercomment,
      moviename:this.moviename,
      ratings:this.rating,
      username:localStorage.getItem('username')
    })
   this.jsonObj=JSON.stringify(this.reviewForm.value);
   console.log(this.jsonObj);
   this.http.post('http://localhost:8989/api/Movie-Reviews/moviereview',this.jsonObj,{headers: {'Content-Type': 'application/json'}}).toPromise()
   .then(data=>{console.log(data)})
  }

}
