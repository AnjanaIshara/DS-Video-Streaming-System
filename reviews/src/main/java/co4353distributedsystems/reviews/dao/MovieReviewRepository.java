package co4353distributedsystems.reviews.dao;

import co4353distributedsystems.reviews.model.MovieReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieReviewRepository extends JpaRepository<MovieReview, Long> {
    @Query("select reviews from MovieReview reviews where reviews.moviename=?1")
    List<MovieReview> findByMovieName(String moviename);
    @Query("select reviews from MovieReview reviews where reviews.ratings>?1")
    List<MovieReview> findRatingAbove(int rating);
    @Query("select reviews from MovieReview reviews where reviews.username=?1")
    List<MovieReview> findByUsername(String username);
}
