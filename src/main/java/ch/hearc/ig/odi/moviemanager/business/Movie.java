/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.business;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebastie.pomi
 */
public class Movie {
    
    private Long id;
    private String name;
    private String producer;
    private List<Person> people;

    /**
     * Constructeur non-parametré de la classe Movie
     * Initialisation de la liste de personnes
     */
    public Movie() {
        this.people = new ArrayList<>();
    }
    /**
     * Constructeur parametré de la classe Movie
     * @param id id du film
     * @param name nom du film
     * @param producer producteur du film
     * Initialisation de la liste de personnes
     */
    public Movie(Long id, String name, String producer) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.people = new ArrayList<>();
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

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
    
    /**
     * Ajouter une personne à la liste
     * @param person personne à ajouter
     */
    public void addPersonn(Person person){
        this.people.add(person);
    }
    
    /**
     * Supprimer une personne à la liste
     * @param person personne à supprimer
     */
    public void removePerson(Person person){
        this.people.remove(person);
    }
    
    
    
    
}
