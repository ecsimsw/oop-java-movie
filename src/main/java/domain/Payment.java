package domain;

import view.InputView;
import view.OutputView;

public class Payment {
    private static final int PAYMENT_METHOD_CARD = 1;
    private static final int PAYMENT_METHOD_CASH = 2;

    private static final int DISCOUNT_RATE_CARD = 5;
    private static final int DISCOUNT_RATE_CASH = 2;

    private int totalPrice;

    public Payment() {
        totalPrice = 0;
    }

    public void addPrice(int addition) {
        totalPrice += addition;
    }

    public void payment() {
        OutputView.printPayment();
        OutputView.printTotalPrice(calculatePaymentPrice());
        OutputView.printPaymentComplete();
    }

    private int calculatePaymentPrice() {
        int point = InputView.askPointMoney();
        int paymentMethod = InputView.askCardOrCash();
        return priceAfterDiscount(point, paymentMethod);
    }

    private int priceAfterDiscount(int point, int paymentMethod) {
        if (paymentMethod == PAYMENT_METHOD_CARD) {
            return (totalPrice - point) * (100 - DISCOUNT_RATE_CARD);
        }
        if (paymentMethod == PAYMENT_METHOD_CASH) {
            return (totalPrice - point) * (100 - DISCOUNT_RATE_CASH);
        }
        throw new IllegalArgumentException("잘못된 접근입니다.");
    }
}
