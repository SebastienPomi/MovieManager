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
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

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
     * Initialise the current Person
     */
    public void initCurrentPerson() {
        currentPerson = services.getPersonWithId(currentPersonID);
        this.searchMoviesMissing();
    }

    public Person getCurrentPerson() {
        return currentPerson;
    }

    public Long getCurrentPersonID() {
        return currentPersonID;
    }

    public void setCurrentPersonID(Long currentPersonID) {
        this.currentPersonID = currentPersonID;
    }

    public Movie getMovieToAdd() {
        return movieToAdd;
    }

    public void setMovieToAdd(Movie movieToAdd) {
        this.movieToAdd = movieToAdd;
    }

    public String deleteMovie(Movie movie) {
       try {
            services.removeMovieFromPerson(currentPerson, movie);

        } catch (NullParameterException | InvalidParameterException ex) {
            Logger.getLogger(PersonBean.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return "list.xhtml?faces-redirect=true&id=" + currentPerson.getId();
    }

    public void searchMoviesMissing() {
        List<Movie> allMovies = services.getMoviesList();
        List<Movie> moviesOfPerson = currentPerson.getMovies();

        for (Movie movie : allMovies) {
            if (moviesOfPerson.indexOf(movie) == -1) {
                this.movieSelect.add(movie);
            }
        }
    }

    public List<Movie> getMovieSelect() {
        return movieSelect;
    }

    public String addMovie(Movie movie) {

        try {
            services.addMovieToPerson(currentPerson, movie);

        } catch (NullParameterException | UniqueException ex) {
            Logger.getLogger(PersonBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "list.xhtml?faces-redirect=true&id=" + currentPerson.getId();
    }

}
