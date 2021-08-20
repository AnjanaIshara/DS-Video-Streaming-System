package co4353distributedsystems.categorizedmovies.service;

import co4353distributedsystems.categorizedmovies.dao.CategorizedMoviesRepository;

import co4353distributedsystems.categorizedmovies.model.CategorizedMovies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategorizedMoviesService {
    @Autowired
    private CategorizedMoviesRepository categorizedMoviesRepository;
    public void saveCategoriezedMovie(CategorizedMovies postData){categorizedMoviesRepository.save(postData);}
    public List<CategorizedMovies> getCategorizedMovies(String movieCategory) {

        return categorizedMoviesRepository.findByCategory(movieCategory);
    }
    public List<String> getAllCategories(){
        return categorizedMoviesRepository.getAllCategories();
    }
    public List<CategorizedMovies> getUserSpecifications(List<String> choices){
        return categorizedMoviesRepository.getUserSpecifications(choices);
    }
}
