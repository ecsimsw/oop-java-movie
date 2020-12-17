package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;

public class Reservations {
    private final List<Reservation> reservations;

    public Reservations(){
        reservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation){
        reservations.add(reservation);
    }
}
