import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import domain.Ticketing;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {

        Ticketing ticketing = new Ticketing();
        ticketing.run();
    }
}