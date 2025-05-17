package Movie_WatchList.demo.controller;


import org.springframework.ui.Model;
import Movie_WatchList.demo.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import Movie_WatchList.demo.repository.MovieRepository;
import Movie_WatchList.demo.service.MovieService;

@Controller
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieService movieService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("movies", movieRepository.findAll());
        return "index";
    }


    @PostMapping("/search")
    public String search(@RequestParam("title") String title) {
        System.out.println("Searching for: " + title);  // 👈 Log to console
        Movie movie = movieService.searchMovie(title);

        if (movie != null) {
            movieRepository.save(movie);
            System.out.println("Saved movie: " + movie.getTitle());  // ✅ Check it's being saved
        } else {
            System.out.println("Movie not found or error fetching from API.");
        }

        return "redirect:/";
    }

    @PostMapping("/toggle")
    public String toggleWatched(@RequestParam("id") Long id) {
        Movie movie = movieRepository.findById(id).orElse(null);

        if (movie != null) {
            movie.setWatched(!movie.isWatched());  // Flip true/false
            movieRepository.save(movie);           // Save update
        }

        return "redirect:/";
    }
}

