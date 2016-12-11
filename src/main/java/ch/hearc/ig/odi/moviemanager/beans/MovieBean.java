/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.beans;

import ch.hearc.ig.odi.moviemanager.business.Movie;
import ch.hearc.ig.odi.moviemanager.service.Services;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author sebastie.pomi
 */
@Named(value = "movieBean")
@RequestScoped
public class MovieBean {
    
    @Inject
    Services services;
    private Movie currentMovie;
    private Long currentMovieID;

    /**
     * Creates a new instance of MovieBean
     */
    public MovieBean() {
    }
    
    public void initCurrentMovie() {
        currentMovie = services.getMovieWithId(currentMovieID);
    }

    public Movie getCurrentMovie() {
        return currentMovie;
    }

    public Long getCurrentMovieID() {
        return currentMovieID;
    }

    public void setCurrentMovieID(Long currentMovieID) {
        this.currentMovieID = currentMovieID;
    }
    
    
    
    
}
