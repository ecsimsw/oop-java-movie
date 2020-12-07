package domain;

import java.util.List;

public class Movies {
    private static final List<Movie> movies = MovieRepository.getMovies();

    private Movies(){}

    public static Movie getMovieById(int id){
        return movies.stream()
                .filter(movie -> movie.isId(id))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
