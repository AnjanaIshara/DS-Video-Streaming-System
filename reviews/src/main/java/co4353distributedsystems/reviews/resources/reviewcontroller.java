package co4353distributedsystems.reviews.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class reviewcontroller {
    @Autowired
    private reviewservice revservice;
    @RequestMapping("/reviews")
    public List<MovieReviews> getReviews(){
        return revservice.getMovieReviews();
    }
    @RequestMapping(method = RequestMethod.POST,value = "/reviews")
    public List<MovieReviews> registerReview(@RequestBody MovieReviews movieReviews){
        revservice.addReview(movieReviews);
        return revservice.getMovieReviews();
    }





}
