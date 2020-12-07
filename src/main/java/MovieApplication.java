import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import jdk.internal.util.xml.impl.Input;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        do{

        }while(InputView.askTicketingMore());

    }
}