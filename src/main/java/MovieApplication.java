import controller.TicketingController;
import domain.Reservations;

public class MovieApplication {
    private final Reservations reservations;
    private final TicketingController ticketingController;

    public MovieApplication(){
        reservations = new Reservations();
        ticketingController = new TicketingController(reservations);
    }

    public void run(){
        do{
            ticketingController.doTicketing();
        }while(ticketingController.hasAdditionalBooking());
    }
}
