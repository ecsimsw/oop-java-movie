package view;

import domain.MovieRepository;

public class OutputView {
    private static final String ERROR_MESSAGE = "[ERROR] %s\n";

    private OutputView() {
    }

    public static void printMovies(){
        MovieRepository.getMovies()
                .stream()
                .forEach(OutputView::println);
    }

    public static void printErrorMsg(Exception e){
        printf(ERROR_MESSAGE, e.getMessage());
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
