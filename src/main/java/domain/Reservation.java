package domain;

import view.InputView;

import java.time.LocalDateTime;

public class Reservation {
    final Movie movie;
    final PlaySchedule schedule;
    final int ticketCount;

    private Reservation(ReservedTimes reservedTimes){
        movie = askMovie();
        schedule = setSchedule(movie, reservedTimes);
        ticketCount = askTicketCount(schedule);
        movie.reserve(schedule, ticketCount);
    }

    public static Reservation create(ReservedTimes reservedTimes) {
        return new Reservation(reservedTimes);
    }

    public int getPrice() {
        return movie.calculatePrice(ticketCount);
    }

    public Ticket getTicket(){
        return movie.getTicket(schedule, ticketCount);
    }

    public LocalDateTime getStartTime(){
        return schedule.getStartDateTime();
    }

    private static Movie askMovie() {
        return InputView.getMovie();
    }

    private static PlaySchedule setSchedule(Movie movie, ReservedTimes reservedTimes) {
        final PlaySchedule schedule = InputView.getSchedule(movie, reservedTimes);
        reservedTimes.add(schedule.getStartDateTime());
        return schedule;
    }

    private static int askTicketCount(PlaySchedule schedule) {
        return InputView.inputNumberOfPeople(schedule);
    }
}
