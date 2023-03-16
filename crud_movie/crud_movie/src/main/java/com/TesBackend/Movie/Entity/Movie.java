package com.TesBackend.Movie.Entity;

import javax.persistence.*;

import java.util.List;

import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    private int movie_id;
    private String title;
    private String rating;
    private String year;
    private String month;
    private String certificate;
    private String runtime;
    @ElementCollection
    private List<String> directors;
    @ElementCollection
    private List<String> stars;
    @ElementCollection
    private List<String> genres;
    private String filming_location;
    private String budget;
    private String income;
    @ElementCollection
    private List<String> country_of_region;

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    public List<String> getStars() {
        return stars;
    }

    public void setStars(List<String> stars) {
        this.stars = stars;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getFilming_location() {
        return filming_location;
    }

    public void setFilming_location(String filming_location) {
        this.filming_location = filming_location;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public List<String> getCountry_of_region() {
        return country_of_region;
    }

    public void setCountry_of_region(List<String> country_of_region) {
        this.country_of_region = country_of_region;
    }
}
