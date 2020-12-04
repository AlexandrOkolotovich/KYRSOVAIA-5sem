package by.bsuir.coursework.collections;

import by.bsuir.coursework.controllers.ControllerAdmin;
import by.bsuir.coursework.entity.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public final class CollectionMovie extends ControllerAdmin {
    private ObservableList<MovieInf> movies = FXCollections.observableArrayList();

    private static CollectionMovie instance;

    public static synchronized CollectionMovie getInstance(){
        if(instance == null){
            instance = new CollectionMovie();
        }
        return instance;
    }

    public ObservableList<MovieInf> getMovies() {
        return movies;
    }

    public void fillNewData(){

        String movieTitle = movieTitleField.getText();
        String prodYear = productionYearField.getText();
        Integer productionYear = Integer.valueOf(prodYear);
        String country = countryField.getText();
        String genre = genreField.getText();
        String director = directorField.getText();
        String age = ageField.getText();
        String t = timeField.getText();
        Integer time = Integer.valueOf(t);
        String description = descriptionArea.getText();
        Integer rating = 0;

        MovieInf movie = new MovieInf(movieTitle, productionYear, country, genre, director, age, time, description, rating);
        movies.add(movie);
    }
}
