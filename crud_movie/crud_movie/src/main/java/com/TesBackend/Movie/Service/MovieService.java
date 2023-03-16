package com.TesBackend.Movie.Service;

import com.TesBackend.Movie.Entity.Movie;
import com.TesBackend.Movie.Repository.MovieRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Transactional
@Service
public class MovieService {
    @Autowired
    ObjectMapper MAPPER;
    @Autowired
    MovieRepository movieRepository;
    public Movie saveData(Movie movie){
        if(getAllMovies().size() > 0){
            int maxVal = Integer.parseInt(movieRepository.getMaxValueId().get("max_id").toString());
            int id = maxVal +1;
            movie.setMovie_id(id);
        }else{
            int maxVal = 0;
            int id = maxVal + 1;
            movie.setMovie_id(id);
        }
        return movieRepository.save(movie);
    }

    public String batchSave() throws CsvValidationException, IOException {
        List<Map<String, Object>> batchData = convertCsvToJson("C:\\Users\\user\\Downloads\\crud_movie\\crud_movie\\movies_1.csv");
        for(Map<String, Object> map : batchData){
        //    List<String> listDirectors = Stream.of(map.get("Directors")).map(Object::toString).collect(Collectors.toList());
            List<String> listDirectors = (List<String>) map.get("Directors");
        //    List<String> listStarts = Stream.of(map.get("Stars")).map(Object::toString).collect(Collectors.toList());
            List<String> listStars = (List<String>) map.get("Stars");
        //    List<String> listCountry = Stream.of(map.get("Country_of_origin")).map(Object::toString).collect(Collectors.toList());
            List<String> listCountry = (List<String>) map.get("Country");
        //    List<String> listGenre = Stream.of(map.get("Genre")).map(Object::toString).collect(Collectors.toList());
            List<String> listGenre = (List<String>) map.get("Genre");
            Movie movie = new Movie();
            movie.setTitle(map.get("\uFEFFTitle").toString());
            movie.setYear(map.get("Year").toString());
            movie.setMonth(map.get("Month").toString());
            movie.setCertificate(map.get("Certificate").toString());
            movie.setRuntime(map.get("Runtime").toString());
            movie.setDirectors(listDirectors);
            movie.setStars(listStars);
            movie.setGenres(listGenre);
            movie.setFilming_location(map.get("Filming_location").toString());
            movie.setBudget(map.get("Budget").toString());
            movie.setIncome(map.get("Income").toString());
            movie.setCountry_of_region(listCountry);
            movie.setRating(map.get("Rating").toString());
            saveData(movie);
        }
        return "selesai";
    }


    public List<Map<String, Object>> convertCsvToJson(String pathFile) throws CsvValidationException, IOException {
        CSVReader reader = new CSVReader(new FileReader(pathFile));
        String[] headers = reader.readNext();
        List<Map<String, Object>> data = new ArrayList<>();

        String[] row;
        while ((row = reader.readNext()) != null) {
            Map<String, Object> record = new HashMap<>();
            for (int i = 0; i < headers.length; i++) {
                String header = headers[i];
                String value = row[i];
                if (header.equals("Directors") || header.equals("Stars") || header.equals("Genre") || header.equals("Country_of_origin")) {
                    value = value.replaceAll("\"", "");
                    List<String> list = Arrays.asList(value.split(","));
                    record.put(header, list);
                } else {
                    record.put(header, value);
                }
            }
            data.add(record);
        }

        System.out.println(MAPPER.writeValueAsString(data));

        return data;
    }


    public List<Movie> getAllMovies(){
        return movieRepository.getAllMovies();
    }
}
