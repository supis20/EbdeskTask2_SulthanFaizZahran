package com.TesBackend.Movie.Repository;

import com.TesBackend.Movie.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query(value = "select max(movie_id) as max_id from movie", nativeQuery = true)
    Map<String, Object> getMaxValueId();

    @Query(value = "select * from movie", nativeQuery = true)
    List<Movie> getAllMovies();
}
