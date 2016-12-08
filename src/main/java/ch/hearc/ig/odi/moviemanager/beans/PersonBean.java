/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.beans;

import ch.hearc.ig.odi.moviemanager.business.Person;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.io.Serializable;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author sebastie.pomi
 */
@Named(value = "personBean")
@ViewScoped
public class PersonBean implements Serializable{
    
    @Inject
    Services service;
    private Map<Long,Person> people;
    private Person currentPerson;
    private int currentPersonId;

    /**
     * Récupérer la personne courante 
     * @return la personne 
     */
    public Person getCurrentPerson() {
        return currentPerson;
    }

    /**
     * Récupérer l'id de la personne courante
     * @return id de la personne
     */
    public int getCurrentPersonId() {
        return currentPersonId;
    }

    /**
     * Modifier l'id de la personne courante
     * @param currentPersonId nouvel id
     */
    public void setCurrentPersonId(int currentPersonId) {
        this.currentPersonId = currentPersonId;
    }
    
    /**
     * Creates a new instance of PersonBean
     */
    public PersonBean() {
    }
    
    /**
     * Initialiser la liste de personnes
     */
    public void initList(){
        this.people = service.getPeople();
    }
    
}
