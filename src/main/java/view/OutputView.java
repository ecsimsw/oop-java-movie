package view;

import domain.Movie;
import domain.ReservedInfo;

import java.time.LocalDateTime;
import java.util.List;

public class OutputView {
    private static final String ticketInfo = "이름 : %s, 가격 : %s, 시작 시간 : %s, 인원 %s \n";
    private OutputView(){}

    public static void printTicketInfo(ReservedInfo reservedInfo){
        printfMsg(ticketInfo,
                reservedInfo.getName(),
                reservedInfo.getPrice(),
                reservedInfo.getStartTime(),
                reservedInfo.getNumberOfPeople());
    }

    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printfMsg(String msg, Object... args ) {
        System.out.printf(msg, args);
    }

    public static void printMsg(Object msg){
        System.out.print(msg);
    }
}
