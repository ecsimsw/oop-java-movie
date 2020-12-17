package domain;

import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieController {
    private static final int BOOK_MORE_BUTTON = 2;
    private static final int STOP_AND_PAYMENT_BUTTON = 1;

    private final Payment payment;

    public MovieController() {
        payment = new Payment();
    }

    public void playBookSystem() {
        printMovies();
        do {
            Reservation reservation = new Reservation();
            payment.addPrice(reservation.calculatePrice());
        } while (checkBookMore());

        payment.payment();
    }

    private void printMovies() {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
    }

    private boolean checkBookMore() {
        return InputView.askBookMoreOrPay() == BOOK_MORE_BUTTON;
    }
}
