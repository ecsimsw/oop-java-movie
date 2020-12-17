package view;

import domain.MovieRepository;

public class OutputView {

    private OutputView() {
    }

    public static void printMovies(){
        MovieRepository.getMovies()
                .stream()
                .forEach(OutputView::println);
    }

    public static void printf(String msg, Object... args) {
        System.out.printf(msg, args);
    }

    public static void print(Object msg) {
        System.out.print(msg);
    }

    public static void println(Object msg) {
        System.out.println(msg);
    }
}
