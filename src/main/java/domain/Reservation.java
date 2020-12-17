package domain;

import utils.DateTimeUtils;

public class Reservation {
    private final static String RESERVATION_INFO_FORMAT
            = "영화 정보 : %s, 시작 시간 : %s, 예약 인원 : %s, 가격 :%s ";

    private final Movie movie;
    private final PlaySchedule schedule;
    private final int count;

    private Reservation(Movie movie, PlaySchedule schedule, int count){
        this.movie = movie;
        this.schedule = schedule;
        this.count = count;
    }

    public static Reservation reserve(Movie movie, PlaySchedule schedule, int count){
        schedule.reserved(count);
        return new Reservation(movie, schedule, count);
    }

    public boolean isWithinOneHour(PlaySchedule playSchedule){
        return DateTimeUtils.isOneHourWithinRange(this.schedule.getStartDateTime(), playSchedule.getStartDateTime());
    }

    public int getPrice(){
        return movie.getPrice() * count;
    }

    @Override
    public String toString(){
        return String.format(RESERVATION_INFO_FORMAT,
                movie.getName(),
                schedule.getStartDateTime(),
                count,
                getPrice());
    }
}