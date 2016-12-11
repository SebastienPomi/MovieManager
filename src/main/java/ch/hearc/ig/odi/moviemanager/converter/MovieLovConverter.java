/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.converter;

import ch.hearc.ig.odi.moviemanager.business.Movie;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.util.Objects;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

/**
 *
 * @author sebastie.pomi
 */
@Named(value = "movieLovConverter")
@Dependent
public class MovieLovConverter implements Converter {

    @Inject
    Services service;

    /**
     * Creates a new instance of movieLovConverter
     */
    public MovieLovConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        } else {
            for (Movie movie : service.getMoviesList()) {
                if (Objects.equals(movie.getId(), Long.valueOf(value))) {
                    return movie;
                }
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        } else {
            Movie movie = (Movie) value;
            return movie.getId().toString();
        }
    }

}

