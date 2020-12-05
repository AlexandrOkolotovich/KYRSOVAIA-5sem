package by.bsuir.coursework.collections;

import by.bsuir.coursework.connection.Connect;
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
        String id = Connect.get();
        Integer idmovie = Integer.valueOf(id);
        String movieTitle = Connect.get(); // тут не работает, надо что-то новое придумать
        String prodYear = Connect.get();
        Integer productionYear = Integer.valueOf(prodYear);
        String country = Connect.get();
        String genre = Connect.get();
        String director = Connect.get();
        String age = Connect.get();
        String t = Connect.get();
        Integer time = Integer.valueOf(t);
        String description = Connect.get();
        String r = Connect.get();
        Integer rating = Integer.valueOf(r);

        MovieInf movie = new MovieInf(idmovie,movieTitle, productionYear, country, genre, director, age, time, description, rating);
        movies.add(movie);
    }
}
