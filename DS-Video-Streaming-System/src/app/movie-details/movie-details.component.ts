import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {HttpClient} from '@angular/common/http';
import { Reviews } from '../review';
import { Observable } from 'rxjs';
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
  
  

}
