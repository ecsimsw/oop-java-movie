package domain;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Ticketing {
    private static final int CARD_DISCOUNT_RATE = 5;
    private static final int CASH_DISCOUNT_RATE = 3;
    private static final int PAY_WITH_CARD = 1;
    private static final int PAY_WITH_CASH = 2;

    private int totalPrice = 0;
    private final ReservedTimes reservedTimes = new ReservedTimes();

    public Ticketing() {
    }

    public void run() {
        final List<Ticket> tickets = new ArrayList<>();

        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        do {
            Ticket info = makeReservation();
            tickets.add(info);
        } while (InputView.askTicketingMore());

        OutputView.printTicketInfo(tickets);

        makePayment();
    }

    private Ticket makeReservation() {
        Movie movie = InputView.getMovie();
        PlaySchedule playSchedule = InputView.getSchedule(movie, reservedTimes);
        reservedTimes.addNew(playSchedule.getStartDateTime());

        int numberOfPeople = InputView.inputNumberOfPeople(playSchedule);
        totalPrice += movie.calculatePrice(numberOfPeople);

        movie.reserve(playSchedule, numberOfPeople);
        return movie.getTicket(playSchedule, numberOfPeople);
    }

    private void makePayment() {
        OutputView.AnnouncePayment();
        usePoint();
        discountByPaymentMethod();
        OutputView.printPaymentInfo(totalPrice);
    }

    private void usePoint(){
        totalPrice -= InputView.getPoint();
    }

    private int discountByPaymentMethod() {
        int paymentMethod = InputView.askCardOrCash();

        if (paymentMethod == PAY_WITH_CARD) {
            totalPrice *= (100 - CARD_DISCOUNT_RATE) / 100;
        }

        if (paymentMethod == PAY_WITH_CASH) {
            totalPrice *= (100 - CASH_DISCOUNT_RATE) / 100;
        }

        throw new IllegalArgumentException("잘못된 접근입니다.");
    }
}
