package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Reservations {
    private final List<Reservation> reservations;

    public Reservations(){
        reservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation){
        reservations.add(reservation);
    }

    public boolean isAcceptableSchedule(PlaySchedule newSchedule){
        return reservations.stream()
                .allMatch(reservation -> reservation.isWithinOneHour(newSchedule));
    }

    public int getTotalPrice(){
        return reservations.stream()
                .mapToInt(Reservation::getPrice)
                .sum();
    }

    @Override
    public String toString(){
        return reservations.stream()
                .map(Reservation::toString)
                .collect(Collectors.joining("\n"));
    }
}
