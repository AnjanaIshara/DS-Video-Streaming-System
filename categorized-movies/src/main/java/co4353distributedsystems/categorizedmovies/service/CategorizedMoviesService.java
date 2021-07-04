package co4353distributedsystems.categorizedmovies.service;

import co4353distributedsystems.categorizedmovies.dao.CategorizedMoviesRepository;

import co4353distributedsystems.categorizedmovies.model.CategorizedMovies;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategorizedMoviesService {
    @Autowired
    private CategorizedMoviesRepository categorizedMoviesRepository;
    public void saveCategoriezedMovie(CategorizedMovies postData){categorizedMoviesRepository.save(postData);}
    public List<CategorizedMovies> getCategorizedMovies(String movieCategory) {

        return categorizedMoviesRepository.findByCategory(movieCategory);
    }
}
