import controller.MovieController;
import controller.PaymentController;
import controller.TicketingController;
import domain.Reservations;
import view.OutputView;

public class MovieApplication {
    private final Reservations reservations;
    private final TicketingController ticketingController;

    public MovieApplication(){
        reservations = new Reservations();
        ticketingController = new TicketingController(reservations);
    }

    public void run(){
        MovieController.printScreeningList();
        do{
            ticketingController.doTicketing();
        }while(ticketingController.hasAdditionalBooking());
        OutputView.println(reservations.toString());
        PaymentController.run(reservations);
    }
}
