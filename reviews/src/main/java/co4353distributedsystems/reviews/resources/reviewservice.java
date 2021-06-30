package co4353distributedsystems.reviews.resources;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class reviewservice {
    private List<MovieReviews> movieReviews=new ArrayList<>(Arrays.asList());
    public List<MovieReviews> getMovieReviews(){
        return movieReviews;
    }
    public void addReview(MovieReviews userreview){
        movieReviews.add(userreview);
    }
}
