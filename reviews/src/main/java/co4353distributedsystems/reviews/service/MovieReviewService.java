package co4353distributedsystems.reviews.service;

import co4353distributedsystems.reviews.dao.MovieReviewRepository;
import co4353distributedsystems.reviews.model.MovieReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MovieReviewService {
    @Autowired
    private MovieReviewRepository movieReviewRepository;
    public void saveReview(MovieReview postData){
        movieReviewRepository.save(postData);
    }
    public List<MovieReview> getReviewForMovie(String movieName){

        return  movieReviewRepository.findByMovieName(movieName);
    }
}
