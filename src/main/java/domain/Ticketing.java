package domain;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Ticketing {
    private int totalPrice = 0;
    private final ReservedTimes reservedTimes = new ReservedTimes();
    private final List<TicketInfo> ticketInfos = new ArrayList<>();

    public Ticketing(){}

    public void run(){
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        do{
            TicketInfo info = makeReservation();
            ticketInfos.add(info);
        }while(InputView.askTicketingMore());

        OutputView.printTicketInfo(ticketInfos);
        OutputView.AnnouncePayment();
    }

    private TicketInfo makeReservation(){
        Movie movie = InputView.getMovie();
        PlaySchedule playSchedule = InputView.getSchedule(movie, reservedTimes);
        reservedTimes.addNew(playSchedule.getStartDateTime());

        int numberOfPeople = InputView.inputNumberOfPeople(playSchedule);
        totalPrice += movie.calculatePrice(numberOfPeople);

        return movie.reserve(playSchedule,numberOfPeople);
    }
}
