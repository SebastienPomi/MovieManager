/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.business;

import ch.hearc.ig.odi.moviemanager.exception.NullParameterException;
import ch.hearc.ig.odi.moviemanager.exception.UniqueException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebastie.pomi
 */
public class Person {
    
    private Long id;
    private String name;
    private String producer;
    private List<Movie> movies;

    public Person() {
        this.movies = new ArrayList<>();
    }

    public Person(Long id, String name, String producer) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.movies = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
    
    public void addMovie(Movie movie) throws UniqueException, NullParameterException {
        
    }
    
    public void removeMovie(Movie movie){
        
    }
    
    
    
    
    
}
