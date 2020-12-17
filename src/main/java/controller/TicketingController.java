package controller;

import domain.*;
import utils.Validator;
import view.InputView;
import view.OutputView;

public class TicketingController {
    private final Reservations reservations;

    public TicketingController(Reservations reservations){
        this.reservations = reservations;
    }

    public void doTicketing(){
        Movie movie = getMovie();
        PlaySchedule schedule = getPlaySchedule(movie);
        int count = getCountOfTicket(schedule);
        reservations.addReservation(new Reservation(movie,schedule,count));
    }

    public boolean hasAdditionalBooking(){
        try{
            return InputView.getHasAdditionalBooking();
        }catch (Exception e ){
            OutputView.printErrorMsg(e);
            return hasAdditionalBooking();
        }
    }

    private Movie getMovie(){
        try{
            int movieId = InputView.getMovieId();
            return MovieRepository.getMovieById(movieId);
        }catch (Exception e){
            OutputView.printErrorMsg(e);
            return getMovie();
        }
    }

    private PlaySchedule getPlaySchedule(Movie movie){
        try{
            int timeId = InputView.getTimeId();
            // TODO :: 유효한 스케줄인지 확인
            return movie.getPlayScheduleByIndex(timeId);
        }catch (Exception e){
            OutputView.printErrorMsg(e);
            return getPlaySchedule(movie);
        }
    }

    private int getCountOfTicket(PlaySchedule playSchedule){
        try{
            int count = InputView.getCount();
            Validator.checkValidCount(playSchedule, count);
            return count;
        }catch (Exception e){
            OutputView.printErrorMsg(e);
            return getCountOfTicket(playSchedule);
        }
    }
}
