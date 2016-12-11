/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.beans;

import ch.hearc.ig.odi.moviemanager.business.Movie;
import ch.hearc.ig.odi.moviemanager.business.Person;
import ch.hearc.ig.odi.moviemanager.exception.InvalidParameterException;
import ch.hearc.ig.odi.moviemanager.exception.NullParameterException;
import ch.hearc.ig.odi.moviemanager.exception.UniqueException;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.inject.Inject;

/**
 *
 * @author sebastie.pomi
 */
@Named(value = "personBean")
@ViewScoped
public class PersonBean implements Serializable {

    @Inject
    Services services;
    private Person currentPerson;
    private Long currentPersonID;
    private Movie movieToAdd;
    private List<Movie> movieSelect;

    /**
     * Creates a new instance of PersonBean
     */
    public PersonBean() {
        movieSelect = new ArrayList();
    }

    /**
     * Initialise la personne courrante
     * Si elle n'existe pas, il en crée une
     * rempli la liste des films manquant
     */
    public void initCurrentPerson() {
        if(currentPersonID == null){
            currentPerson = new Person();
        } else {
        currentPerson = services.getPersonWithId(currentPersonID);
        }
        this.searchMoviesMissing();
    }

    /**
     * 
     * @return la personne courrante 
     */
    public Person getCurrentPerson() {
        return currentPerson;
    }

    /**
     * 
     * @return l'id de la personne courrante
     */
    public Long getCurrentPersonID() {
        return currentPersonID;
    }

    /**
     * Modifie l'id de la personne courrante
     * @param currentPersonID 
     */
    public void setCurrentPersonID(Long currentPersonID) {
        this.currentPersonID = currentPersonID;
    }

    /**
     * 
     * @return le film à ajouter
     */
    public Movie getMovieToAdd() {
        return movieToAdd;
    }

    /**
     * Modifier le film à ajouter
     * @param movieToAdd 
     */
    public void setMovieToAdd(Movie movieToAdd) {
        this.movieToAdd = movieToAdd;
    }

    /**
     * Suppression du film
     * @param movie
     * @return chemin de redirection
     */
    public String deleteMovie(Movie movie) {
       try {
            services.removeMovieFromPerson(currentPerson, movie);

        } catch (NullParameterException | InvalidParameterException ex) {
            Logger.getLogger(PersonBean.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return "list.xhtml?faces-redirect=true&id=" + currentPerson.getId();
    }

    /**
     * Rechercher les films que la personne n'a pas vu
     */
    public void searchMoviesMissing() {
        List<Movie> allMovies = services.getMoviesList();
        List<Movie> moviesOfPerson = currentPerson.getMovies();

        for (Movie movie : allMovies) {
            if (moviesOfPerson.indexOf(movie) == -1) {
                this.movieSelect.add(movie);
            }
        }
    }

    /**
     * 
     * @return la liste de film
     */
    public List<Movie> getMovieSelect() {
        return movieSelect;
    }

    /**
     * Ajouter un film
     * @param movie
     * @return le chemin de redirection
     */
    public String addMovie(Movie movie) {

        try {
            services.addMovieToPerson(currentPerson, movie);

        } catch (NullParameterException | UniqueException ex) {
            Logger.getLogger(PersonBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "list.xhtml?faces-redirect=true&id=" + currentPerson.getId();
    }
    
    /**
     * Sauvegarder une nouvelle personne
     * @param person
     * @return le chemin de redirection
     */
    public String save(Person person){
        try {
            services.savePerson(person);
        } catch (NullParameterException ex) {
            Logger.getLogger(PersonBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "list.xhtml?faces-redirect=true&id=" + currentPerson.getId();
    }

}
