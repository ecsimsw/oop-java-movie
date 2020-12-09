import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class TicketingController {
    private static final int CARD_DISCOUNT_RATE = 5;
    private static final int CASH_DISCOUNT_RATE = 3;
    private static final int PAY_WITH_CARD = 1;
    private static final int PAY_WITH_CASH = 2;

    private int totalPrice = 0;
    private final ReservedTimes reservedTimes = new ReservedTimes();

    public TicketingController() {
    }

    public void run() {
        final List<Ticket> tickets = new ArrayList<>();

        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        do {
            Reservation newReservation = Reservation.create(reservedTimes);
            totalPrice += newReservation.getPrice();
            reservedTimes.addNew(newReservation.getStartTime());
            tickets.add(newReservation.getTicket());
        } while (InputView.askTicketingMore());

        OutputView.printTicketInfo(tickets);

        makePayment();
    }

    private void makePayment() {
        OutputView.AnnouncePayment();
        usePoint();
        discount(InputView.askCardOrCash());
        OutputView.printPaymentInfo(totalPrice);
    }

    private void usePoint() {
        totalPrice -= InputView.getPoint();
    }

    private void discount(int method){
        if (method == PAY_WITH_CARD) {
            totalPrice *= (100 - CARD_DISCOUNT_RATE) / 100;
        }

        if (method == PAY_WITH_CASH) {
            totalPrice *= (100 - CASH_DISCOUNT_RATE) / 100;
        }
    }
}
