package domain;

import utils.DateTimeUtils;
import view.InputView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ticketing {
    private int money;
    private final List<LocalDateTime> reservedList = new ArrayList<>();

    public Ticketing(){}

    public void reserveTicket(){
        Movie movie = InputView.getMovie();
        PlaySchedule playSchedule = getPlaySchedule(movie);
        int numberOfPeople = InputView.inputNumberOfPeople(playSchedule);
    }

    private PlaySchedule getPlaySchedule(Movie movie){
        PlaySchedule playSchedule = InputView.getSchedule(movie, reservedList);
        reservedList.add(playSchedule.getStartDateTime());
        Collections.sort(reservedList);
        return playSchedule;
    }
}
