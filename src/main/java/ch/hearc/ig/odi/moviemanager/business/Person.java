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
    private String firstname;
    private String lastname;
    private List<Movie> movies;
    
    /**
     * Constructeur non paramétré de la classe Person
     * Initialisation de la liste de film
     */
    public Person() {
        this.movies = new ArrayList<>();
    }
    
    /**
     * Constructeur paramétré de la classe Person
     * @param id l'id de la personne
     * @param firstname prénom de la personne
     * @param lastname  nom de la personne
     * initialisation de la liste de film de la personne
     */
    public Person(Long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.movies = new ArrayList<>();
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
    
    /**
     * Ajouter un film à la liste de la personne et ajouter la personne dans le film
     * @param movie film à ajouter
     * @throws UniqueException
     * @throws NullParameterException 
     */
    public void addMovie(Movie movie) throws UniqueException, NullParameterException {
        this.movies.add(movie);
        movie.addPersonn(this);
        
    }
    /**
     * Supprimer un film de la liste de la personne et supprimer la personne du film
     * @param movie 
     */
    public void removeMovie(Movie movie){
        this.movies.remove(movie);
        movie.removePerson(this);
    }
    
    
    
    
    
}
