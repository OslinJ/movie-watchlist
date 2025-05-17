package Movie_WatchList.demo.repository;

import Movie_WatchList.demo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByWatched(boolean watched);


}
