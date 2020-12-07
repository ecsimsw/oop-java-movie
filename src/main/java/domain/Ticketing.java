package domain;

import view.InputView;
import view.OutputView;

import java.util.List;

public class Ticketing {
    private int totalPrice = 0;
    private final ReservedTimes reservedTimes = new ReservedTimes();

    public Ticketing(){}

    public void run(){
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        do{
            makeReservation();
        }while(InputView.askTicketingMore());
    }

    public void makeReservation(){
        Movie movie = InputView.getMovie();
        PlaySchedule playSchedule = InputView.getSchedule(movie, reservedTimes);
        reservedTimes.addNew(playSchedule.getStartDateTime());

        int numberOfPeople = InputView.inputNumberOfPeople(playSchedule);
        totalPrice += movie.calculatePrice(numberOfPeople);
    }
}
