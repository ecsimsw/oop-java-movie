package controller;

import domain.MovieRepository;
import view.OutputView;

public class MovieController {
    private MovieController(){}

    public static void printScreeningList(){
        MovieRepository.getMovieInfo().stream()
                .forEach(OutputView::println);
    }
}
