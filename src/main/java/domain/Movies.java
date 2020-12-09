package domain;

import java.util.List;

public class Movies {
    private static final List<Movie> movies = MovieRepository.getMovies();

    private Movies() {
    }

    // getById 패턴은 잘 쓰일 것 같다.
    public static Movie getMovieById(int id) {
        return movies.stream()
                .filter(movie -> movie.isId(id))
                .findFirst()
//                .orElseThrow(IllegalArgumentException::new);  에러 메시지를 남기는 것이 더 좋겠다.
                .orElseThrow(()->new IllegalArgumentException("검색 정보 없음"));
    }
}
