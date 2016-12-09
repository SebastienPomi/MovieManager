/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.beans;

import ch.hearc.ig.odi.moviemanager.business.Movie;
import ch.hearc.ig.odi.moviemanager.business.Person;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author sebastie.pomi
 */
@Named(value = "indexBean")
@RequestScoped
public class IndexBean implements Serializable{
    
    @Inject
    Services service;
    List<Person> peopleList;
    List<Movie> moviesList;

    /**
     * Creates a new instance of IndexBean
     */
    public IndexBean() {
    }
    
    /**
     * Initialisation des listes
     */
    public void init(){
        this.peopleList = service.getPeopleList();
        this.moviesList = service.getMoviesList();
    }

    /**
     *  Retourn la liste de toutes les personnes
     * @return peopleList
     */
    public List<Person> getPeopleList() {
        return peopleList;
    }

    /**
     * Retourne la liste de tous les films
     * @return moviesList
     */
    public List<Movie> getMoviesList() {
        return moviesList;
    }
}
