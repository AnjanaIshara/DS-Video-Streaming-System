package co4353distributedsystems.reviews.controller;

import co4353distributedsystems.reviews.model.MovieReview;
import co4353distributedsystems.reviews.service.MovieReviewService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieReviewController {
    @Autowired
    private MovieReviewService movieReviewService;

    @PostMapping("/moviereview")
    public ResponseEntity movieReviewPostMethod(@RequestBody MovieReview movieReview) {
        movieReviewService.saveReview(movieReview);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/moviereview/{moviename}")
    public List<MovieReview> getReviews(@PathVariable String moviename) {
        List<MovieReview> reviewsForSpecificMovie = movieReviewService.getReviewForMovie(moviename);
        return reviewsForSpecificMovie;
    }

    @GetMapping("/getreviewbyrating/{ratingvalue}")
    public List<MovieReview> getReviewsByRating(@PathVariable int ratingvalue){
        return movieReviewService.getReviewsAbove(ratingvalue);
    }
    @GetMapping("/getreviewbyusername/{username}")
    public List<MovieReview> getReviewsByUsername(@PathVariable String username){
        return movieReviewService.getUserReviews(username);
    }
}
