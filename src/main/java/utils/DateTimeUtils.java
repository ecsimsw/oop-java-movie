package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
    public static final String PLAYING_TIME_FORMAT = "yyyy-MM-dd HH:mm";
    public static final int ONE_HOURS = 1;

    public static LocalDateTime createDateTime(String dateTime) {
        return createDateTime(dateTime, PLAYING_TIME_FORMAT);
    }

    public static LocalDateTime createDateTime(String dateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(dateTime, formatter);
    }

    public static String format(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PLAYING_TIME_FORMAT);
        return dateTime.format(formatter);
    }

    public static boolean isOneHourWithinRange(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        LocalDateTime startDateTime = dateTime1.minusHours(ONE_HOURS);
        LocalDateTime endDateTime = dateTime1.plusHours(ONE_HOURS);
        return dateTime2.isAfter(startDateTime) && dateTime2.isBefore(endDateTime);
    }

    private static void checkOneHourWithinRange(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        if(!isOneHourWithinRange(dateTime1, dateTime2)){
            throw new IllegalArgumentException();
        }
    }

    public static void checkInRange(LocalDateTime time, LocalDateTime first, LocalDateTime last){
        if(time.isBefore(first)){
            checkOneHourWithinRange(time, last);
        }

        if(time.isAfter(last)){
            checkOneHourWithinRange(time, first);
        }
    }
}
