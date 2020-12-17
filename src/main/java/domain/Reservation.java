package domain;

public class Reservation {

    private final Movie movie;
    private final PlaySchedule schedule;
    private final int count;

    public Reservation(Movie movie, PlaySchedule schedule, int count){
        this.movie = movie;
        this.schedule = schedule;
        this.count = count;
    }
}