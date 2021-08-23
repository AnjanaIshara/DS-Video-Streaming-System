package co4353distributedsystems.categorizedmovies.dao;

import co4353distributedsystems.categorizedmovies.model.CategorizedMovies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategorizedMoviesRepository extends JpaRepository<CategorizedMovies,Long> {
    @Query("select movies from CategorizedMovies movies where movies.category=?1")
    List<CategorizedMovies> findByCategory(String category);
    @Query("select DISTINCT category from CategorizedMovies ")
    List<String> getAllCategories();
    @Query("select  movies from CategorizedMovies movies where movies.category IN ?1")
    List<CategorizedMovies> getUserSpecifications(List<String> choices);
    @Query("Select movies.url from CategorizedMovies  movies WHERE movies.moviename=?1")
    String getImageUrl(String moviename);

}
