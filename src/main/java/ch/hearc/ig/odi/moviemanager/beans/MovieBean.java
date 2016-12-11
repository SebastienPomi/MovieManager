/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.beans;

import ch.hearc.ig.odi.moviemanager.business.Movie;
import ch.hearc.ig.odi.moviemanager.exception.NullParameterException;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author sebastie.pomi
 */
@Named(value = "movieBean")
@ViewScoped
public class MovieBean implements Serializable{

    @Inject
    Services services;
    private Movie currentMovie;
    private Long currentMovieID;

    /**
     * Creates a new instance of MovieBean
     */
    public MovieBean() {
    }

    /**
     * initialiser le film courrant
     * Si n'existe pas, il faut créer un nouveau film
     */
    public void initCurrentMovie() {
        if (currentMovieID == null) {
            currentMovie = new Movie();
        } else {
            currentMovie = services.getMovieWithId(currentMovieID);
        }

    }
    
    /**
     * 
     * @return le film courrant
     */
    public Movie getCurrentMovie() {
        return currentMovie;
    }

    /**
     * 
     * @return l'id du film courrant
     */
    public Long getCurrentMovieID() {
        return currentMovieID;
    }

    /**
     * modifier l'id du film courrant
     * @param currentMovieID 
     */
    public void setCurrentMovieID(Long currentMovieID) {
        this.currentMovieID = currentMovieID;
    }
    
    /**
     * Sauvegarde le film
     * @param movie
     * @return le chemin de redirection
     */
    public String save(Movie movie){
        try {
            services.saveMovie(movie);
        } catch (NullParameterException ex) {
            Logger.getLogger(MovieBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "details.xhtml?faces-redirect=true&id=" + currentMovie.getId();
    }

}
