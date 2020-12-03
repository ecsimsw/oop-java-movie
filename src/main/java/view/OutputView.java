package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printfMsg(String msg, Object... args){
        System.out.printf(msg, args);
    }

    public static void printMsg(String msg){
        System.out.print(msg);
    }
}
