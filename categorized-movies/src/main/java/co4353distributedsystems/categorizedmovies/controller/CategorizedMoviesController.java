package co4353distributedsystems.categorizedmovies.controller;

import co4353distributedsystems.categorizedmovies.model.CategorizedMovies;
import co4353distributedsystems.categorizedmovies.service.CategorizedMoviesService;
import org.hibernate.cfg.CreateKeySecondPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CategorizedMoviesController {
    @Autowired
    private CategorizedMoviesService categorizedMoviesService;

    @CrossOrigin
    @PostMapping("/categorizedmovie")
    public ResponseEntity categorizedMoviePostMethod(@RequestBody CategorizedMovies categorizedMovies){
        categorizedMoviesService.saveCategoriezedMovie(categorizedMovies);
        return new ResponseEntity(HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/categorizedmovie/{category}")
    public List<CategorizedMovies> getcategorizedMovies(@PathVariable String category){
        return categorizedMoviesService.getCategorizedMovies(category);
    }
    @CrossOrigin
    @GetMapping("/getallcategories")
    public List<String> getAllCategories(){
        return categorizedMoviesService.getAllCategories();
    }

    @CrossOrigin
    @GetMapping("/getspecificurl/{moviename}")
    public String getImageUrl(@PathVariable String moviename){

        return categorizedMoviesService.getImageUrl(moviename);
    }




}
