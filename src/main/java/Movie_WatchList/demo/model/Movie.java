package Movie_WatchList.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String imdbId;
    private String posterUrl;
    private boolean watched;

    public Movie(){}

    public Movie(String title, String imdbId, String posterUrl, boolean watched) {
        this.title = title;
        this.imdbId = imdbId;
        this.posterUrl = posterUrl;
        this.watched = watched;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getImdbId() {
        return imdbId;
    }
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }
    public String getPosterUrl() {
        return posterUrl;
    }
    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }
    public boolean isWatched() {
        return watched;
    }
    public void setWatched(boolean watched) {
        this.watched = watched;
    }
    @Override
    public String toString() {
        return "model.Movie{" +
               "id= " + getId() +
               ", title='" + getTitle() + '\'' +
               ", imdbId='" + getImdbId() + '\'' +
               ", posterUrl='" + getPosterUrl() + '\'' +
               ", watched=" + watched +
               '}';
    }

}
