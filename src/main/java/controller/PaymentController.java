package controller;

import domain.Reservations;
import view.InputView;

public class PaymentController {
    private static final int DISCOUNT_RATE_WITH_CARD = 5;

    private final Reservations reservations;

    public PaymentController(Reservations reservations){
        this.reservations = reservations;
    }

    public void run(){
        int totalPrice = reservations.getTotalPrice();

    }

    private int getPoint(int totalPrice){
        return InputView.getPoint(totalPrice);
    }
}
