package view;

import domain.Movie;
import domain.TicketInfo;

import java.util.List;

public class OutputView {
    private static final String TICKET_INFO_MESSAGE = "이름 : %s, 가격 : %s, 시작 시간 : %s, 인원 %s \n";
    private static final String PAYMENT_MESSAGE = "결제를 진행합니다. \n";
    private static final String PAYMENT_RESULT_MESSAGE = "최종 결제한 금액은 %s \n 예매를 완료했습니다. 즐거운 영화 관람 되세요.\n";

    private OutputView(){}

    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printTicketInfo(List<TicketInfo> ticketInfos){
        for(TicketInfo info : ticketInfos){
            printfMsg(TICKET_INFO_MESSAGE,
                    info.getName(),
                    info.getPrice(),
                    info.getStartTime(),
                    info.getNumberOfPeople());
        }
    }

    public static void AnnouncePayment(){
        printMsg(PAYMENT_MESSAGE);
    }


    public static void printPaymentInfo(int paidPrice){
        printfMsg(PAYMENT_RESULT_MESSAGE, paidPrice);
    }

    public static void printfMsg(String msg, Object... args ) {
        System.out.printf(msg, args);
    }

    public static void printMsg(Object msg){
        System.out.print(msg);
    }
}
