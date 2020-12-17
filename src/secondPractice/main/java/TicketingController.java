import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class TicketingController {

    private final Payment payment;
    private final ReservedTimes reservedTimes;

    public TicketingController() {
        payment = Payment.create();
        reservedTimes = new ReservedTimes();
    }

    public void run() {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        makeReservation();
        doPayment();

        OutputView.announceResult();
    }

    private void makeReservation() {
        final List<Ticket> tickets = new ArrayList<>();
        do {
            Reservation reservation = Reservation.create(reservedTimes);
            payment.addPrice(reservation.getPrice());
            reservedTimes.add(reservation.getStartTime());
            tickets.add(reservation.getTicket());
        } while (InputView.askTicketingMore());

        OutputView.printTicketInfo(tickets);
    }

    private void doPayment() {
        OutputView.announcePayment();

        int userPoint = InputView.getPoint();
        int paymentMethod = InputView.askCardOrCash();

        payment.discount(userPoint, paymentMethod);

        OutputView.printMsg(payment.paymentInfo());
    }
}
