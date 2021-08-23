package co4353distributedsystems.reviews.controller;

import co4353distributedsystems.reviews.model.MovieReview;
import co4353distributedsystems.reviews.service.MovieReviewService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MovieReviewController {
    @Autowired
    private MovieReviewService movieReviewService;
    @Autowired
    private RestTemplate restTemplate;
    @CrossOrigin
    @PostMapping("/moviereview")
    public ResponseEntity movieReviewPostMethod(@RequestBody MovieReview movieReview) {
        movieReviewService.saveReview(movieReview);
        return new ResponseEntity(HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/moviereview/{moviename}")
    public ResponseEntity getReviews(@PathVariable String moviename) {
        JSONObject returnObject=new JSONObject();
        String imgUrl=restTemplate.getForObject("http://categorized-movies/getspecificurl/"+moviename,String.class);
        returnObject.put("imageurl",imgUrl);

        List<MovieReview> reviewsForSpecificMovie = movieReviewService.getReviewForMovie(moviename);
        returnObject.put("results",reviewsForSpecificMovie);
        return new ResponseEntity(returnObject,HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/getreviewbyrating/{ratingvalue}")
    public List<MovieReview> getReviewsByRating(@PathVariable int ratingvalue){
        return movieReviewService.getReviewsAbove(ratingvalue);
    }
    @CrossOrigin
    @GetMapping("/getreviewbyusername/{username}")
    public List<MovieReview> getReviewsByUsername(@PathVariable String username){
        return movieReviewService.getUserReviews(username);
    }
}
