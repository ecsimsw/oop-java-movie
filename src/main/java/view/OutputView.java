package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    private static final String ANNOUNCE_PROCEED_PAYMENT = "## 결제를 진행합니다.\n";
    private static final String ANNOUNCE_TOTAL_PRICE = "최종 결제 금액은 %s 입니다.\n";
    private static final String ANNOUNCE_PAYMENT_COMPLETE = "예매를 완료했습니다. 즐거운 영화 관람 되세요.\n";

    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printPayment(){
        printMsg(ANNOUNCE_PROCEED_PAYMENT);
    }

    public static void printTotalPrice(int totalPrice){
        printfMsg(ANNOUNCE_TOTAL_PRICE, totalPrice);
    }

    public static void printPaymentComplete(){
        printMsg(ANNOUNCE_PAYMENT_COMPLETE);
    }

    public static void printfMsg(String msg, Object... args){
        System.out.printf(msg, args);
    }

    public static void printMsg(String msg){
        System.out.print(msg);
    }
}
