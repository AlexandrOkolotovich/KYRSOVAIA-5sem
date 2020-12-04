package by.bsuir.coursework.entity;

public final class Movie {
    private String movieTitle;
    private String productionYear;
    private String country;
    private String genre;
    private String director;
    private String age;
    private String time;
    private String description;
    private String rating;

    public Movie(String productionYear, String country, String genre, String director, String age, String time) {
        this.productionYear = productionYear;
        this.country = country;
        this.genre = genre;
        this.director = director;
        this.age = age;
        this.time = time;
    }

    @Override
    public String toString() {
        return productionYear + ' ' + country + ' ' + genre + ' ' + director + ' ' + age + ' ' + time;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(String productionYear) {
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
