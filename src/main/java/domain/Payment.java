package domain;

public class Payment {
    private static final int CARD_DISCOUNT_RATE = 5;
    private static final int CASH_DISCOUNT_RATE = 3;
    private static final int PAY_WITH_CARD = 1;
    private static final int PAY_WITH_CASH = 2;

    int totalPrice;

    private Payment() {
        totalPrice = 0;
    }

    public static Payment create() {
        return new Payment();
    }

    public void addPrice(int price) {
        totalPrice += price;
    }

    public void discount(int point, int method) {
        usePoint(point);
        discountByPaymentMethod(method);
    }

    private void usePoint(int point) {
        totalPrice -= point;
    }

    private void discountByPaymentMethod(int method) {
        if (method == PAY_WITH_CARD) {
            totalPrice *= (100 - CARD_DISCOUNT_RATE) / 100;
        }

        if (method == PAY_WITH_CASH) {
            totalPrice *= (100 - CASH_DISCOUNT_RATE) / 100;
        }
    }

    public String paymentInfo() {
        return "최종 결제한 금액은 " + totalPrice + " 입니다.";
    }
}
