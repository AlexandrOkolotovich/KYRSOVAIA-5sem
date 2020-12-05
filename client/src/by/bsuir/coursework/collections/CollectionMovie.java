package by.bsuir.coursework.collections;

import by.bsuir.coursework.connection.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class CollectionMovie{
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
        String movieTitle = Connect.get();
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

    public void fillData(){
        try {
            movies.removeAll(movies);
            String array = Connect.get();
            System.out.println(array);
            JSONArray newArray = null;
            if (array != null) {
                newArray = new JSONArray(array);
                int count = newArray.length();
                for(int i = 0; i<count; i++) {
                    JSONObject object = newArray.getJSONObject(i);
                    Integer idmovie = object.getInt("idmovie");
                    String movieTitle = object.getString( "movieTitle" );
                    Integer productionYear = object.getInt( "productionYear" );
                    String country = object.getString( "country" );
                    String genre = object.getString( "genre" );
                    String director = object.getString( "director" );
                    String age = object.getString("age");
                    Integer time = object.getInt("time");
                    String description = object.getString("description");
                    Integer rating = object.getInt("rating");
                    MovieInf movie = new MovieInf(idmovie, movieTitle, productionYear, country, genre, director, age, time, description, rating);
                    movies.add(movie);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void delete(MovieInf movie){
        movies.remove(movie);
    }
}
