package Movie_WatchList.demo.service;

import Movie_WatchList.demo.model.Movie;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;

@Service
public class MovieService {

    private final String apiKey = "f8511c7861865b1cac7b77b86f12a6d0";

    public Movie searchMovie(String query){
        String url = UriComponentsBuilder.fromUri(URI.create("https://api.themoviedb.org/3/search/movie"))
                .queryParam("api_key", apiKey)
                .queryParam("query", query)
                .queryParam("language", "en-US")
                .queryParam("page", 1)
                .toUriString();

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        JSONObject jsonObject = new JSONObject(response);
        JSONArray results = jsonObject.getJSONArray("results");

        if(results.isEmpty()){
            return null;
        }
        JSONObject firstResult = results.getJSONObject(0);

        String title = firstResult.getString("title");
        String imdbId = String.valueOf(firstResult.getInt("id"));
        String posterPath = firstResult.getString("poster_path");
        String posterUrl = "https://image.tmdb.org/t/p/w200" + posterPath;

        return new Movie(title, imdbId, posterUrl, false);


    }

}
