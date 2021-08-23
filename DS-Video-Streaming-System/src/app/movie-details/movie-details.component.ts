import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {HttpClient} from '@angular/common/http';
import { Reviews } from '../review';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css']
})
export class MovieDetailsComponent implements OnInit {
  moviename:any;
  constructor(private route: ActivatedRoute,private http: HttpClient) { }
  
  ngOnInit(): void {
    this.moviename=this.route.snapshot.paramMap.get('movie_name');
    console.log(this.moviename);
    this.getMovieReviews(this.moviename).subscribe(data=>console.log(data));
  }
  getMovieReviews(id:any):Observable<Reviews[]>{
    return this.http.get<Reviews[]>(`http://localhost:8989/api/Movie-Reviews/moviereview/${id}`);
  }
  
  

}
