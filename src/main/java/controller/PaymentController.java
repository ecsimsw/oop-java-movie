package controller;

import domain.Reservations;
import view.InputView;
import view.OutputView;

public class PaymentController {
    private static final int DISCOUNT_RATE_WITH_CARD = 5;

    public static void run(Reservations reservations){
        int totalPrice = reservations.getTotalPrice();
        totalPrice -= InputView.getPoint(totalPrice);
        OutputView.println(totalPrice);
    }
}
