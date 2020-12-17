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
        int count = getNumberOfTicket(schedule);
        Reservation reservation = Reservation.reserve(movie, schedule, count);
        reservations.addReservation(reservation);
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
            PlaySchedule schedule = movie.getPlayScheduleByIndex(InputView.getTimeId());
            Validator.checkInvalidSchedule(reservations, schedule);
            return schedule;
        }catch (Exception e){
            OutputView.printErrorMsg(e);
            return getPlaySchedule(movie);
        }
    }

    private int getNumberOfTicket(PlaySchedule playSchedule){
        try{
            int count = InputView.getCount();
            Validator.checkValidCount(playSchedule, count);
            return count;
        }catch (Exception e){
            OutputView.printErrorMsg(e);
            return getNumberOfTicket(playSchedule);
        }
    }
}
