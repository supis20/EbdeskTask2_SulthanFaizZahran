package com.TesBackend.Movie;

import com.TesBackend.Movie.Entity.Movie;
import com.TesBackend.Movie.Service.MovieService;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("addMovies")
    public Movie addMovies(@RequestBody Movie movie){
        return movieService.saveData(movie);
    }

    @PostMapping("insertBatch")
    public String insertBatch() throws CsvValidationException, IOException {
        return movieService.batchSave();
    }

    @GetMapping("getAllMovies")
    public List<Movie> getAllMovies() throws CsvValidationException, IOException {
        return movieService.getAllMovies();
    }

}
