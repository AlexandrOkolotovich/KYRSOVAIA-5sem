package by.bsuir.coursework.collections;

public class MovieInf {
    private Integer idmovie;
    private String movieTitle;
    private Integer productionYear;
    private String country;
    private String genre;
    private String director;
    private String age;
    private Integer time;
    private String description;
    private Integer rating;

    public MovieInf(Integer idmovie, String movieTitle, Integer productionYear, String country, String genre, String director, String age, Integer time, String description, Integer rating) {
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

    public Integer getIdmovie() {
        return idmovie;
    }

    public void setIdmovie(Integer idmovie) {
        this.idmovie = idmovie;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
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

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
