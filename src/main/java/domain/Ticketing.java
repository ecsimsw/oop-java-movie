package domain;

import view.InputView;
import view.OutputView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ticketing {
    private int totalPrice = 0;
    private final List<LocalDateTime> reservedTimes = new ArrayList<>();

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
        PlaySchedule playSchedule = getPlaySchedule(movie);
        int numberOfPeople = InputView.inputNumberOfPeople(playSchedule);
        totalPrice += movie.calculatePrice(numberOfPeople);
    }

    private PlaySchedule getPlaySchedule(Movie movie){
        PlaySchedule playSchedule = InputView.getSchedule(movie, reservedTimes);
        reservedTimes.add(playSchedule.getStartDateTime());
        Collections.sort(reservedTimes);
        return playSchedule;
    }
}
