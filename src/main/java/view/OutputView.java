package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    private OutputView(){}

    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMsg(Object msg){
        System.out.print(msg);
    }
}
