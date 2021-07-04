package co4353distributedsystems.categorizedmovies.dao;

import co4353distributedsystems.categorizedmovies.model.CategorizedMovies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategorizedMoviesRepository extends JpaRepository<CategorizedMovies,Long> {
    @Query("select movies from CategorizedMovies movies where movies.category=?1")
    List<CategorizedMovies> findByCategory(String category);
}
