package domain;

import utils.InputValidator;
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

    public Ticketing(){}

    public void run(){
        final List<TicketInfo> ticketInfos = new ArrayList<>();

        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        do{
            TicketInfo info = makeReservation();
            ticketInfos.add(info);
        }while(InputView.askTicketingMore());

        OutputView.printTicketInfo(ticketInfos);

        makePayment();
    }

    private TicketInfo makeReservation(){
        Movie movie = InputView.getMovie();
        PlaySchedule playSchedule = InputView.getSchedule(movie, reservedTimes);
        reservedTimes.addNew(playSchedule.getStartDateTime());

        int numberOfPeople = InputView.inputNumberOfPeople(playSchedule);
        totalPrice += movie.calculatePrice(numberOfPeople);

        return movie.reserve(playSchedule,numberOfPeople);
    }

    private void makePayment(){
        OutputView.AnnouncePayment();
        int point = InputView.getPoint();
        int leftPrice = totalPrice - point;

        int paidPrice = discount(leftPrice);
        OutputView.printPaymentInfo(paidPrice);
    }

    private int discount(int price){
        int answer = InputView.askCardOrCash();

        if( answer == PAY_WITH_CARD){
            return price * (100- CARD_DISCOUNT_RATE) /100;
        }

        if(answer == PAY_WITH_CASH){
            return price * (100 - CASH_DISCOUNT_RATE) /100;
        }

        throw new IllegalArgumentException("잘못된 접근입니다.");
    }
}
