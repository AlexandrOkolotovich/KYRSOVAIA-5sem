package by.bsuir.coursework.database;

public class Movie {
    private int idmovie;
    private String movieTitle;
    private int productionYear;
    private String country;
    private String genre;
    private String director;
    private String age;
    private int time;
    private String description;
    private int rating;

    public Movie(int idmovie, String movieTitle, int productionYear, String country, String genre, String director, String age, int time, String description, int rating) {
        this.idmovie = idmovie;
        this.movieTitle = movieTitle;
        this.productionYear = productionYear;
        this.country = country;
        this.genre = genre;
        this.director = director;
        this.age = age;
        this.time = time;
        this.description = description;
        this.rating = rating;
    }

    public int getIdmovie() {
        return idmovie;
    }

    public void setIdmovie(int idmovie) {
        this.idmovie = idmovie;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
