package view;

import domain.*;
import utils.DateTimeUtils;

import java.util.List;
import java.time.LocalDateTime;
import java.util.Scanner;

public class InputView {
    private InputView(){}

    private static final Scanner scanner = new Scanner(System.in);

    public static Movie getMovie() {
        OutputView.printMsg("## 예약할 영화를 선택하세요.\n");
        try{
            return Movies.getMovieById(getInteger());
        }catch (Exception E){
            OutputView.printMsg("존재하지 않는 영화입니다. \n");
            return getMovie();
        }
    }

    public static PlaySchedule getSchedule(Movie movie, ReservedTimes reservedTimes) {
        try{
            OutputView.printMsg("## 예약할 시간를 선택하세요.\n");
            PlaySchedule playSchedule = movie.getScheduleById(getInteger());
            reservedTimes.checkValidTime(playSchedule.getStartDateTime());
            return playSchedule;
        }catch (Exception e){
            OutputView.printMsg(e.getMessage());
            return getSchedule(movie, reservedTimes);
        }
    }

    public static int inputNumberOfPeople(PlaySchedule playSchedule) {
        OutputView.printMsg("## 예약할 인원을 입력하세요.\n");
        int numberOfPeople = getInteger();
        if(playSchedule.isAcceptable(numberOfPeople)){
            return numberOfPeople;
        }

        OutputView.printMsg("유효하지 않은 인원 입력입니다.");
        return inputNumberOfPeople(playSchedule);
    }

    public static boolean askTicketingMore(){
        OutputView.printMsg("## 예약을 종료하고 결제를 진행하려면 1, 추가 예약을 진행하시려면 2\n");
        int answer = getInteger();

        // 범위 처리

        if(answer == 1){
            return false;
        }

        return true;
    }

    private static int getInteger(){
        try{
            return Integer.parseInt(getInput());
        }catch (Exception e){
            OutputView.printMsg("숫자를 입력하세요.");
            return getInteger();
        }
    }

    private static String getInput(){
        return scanner.nextLine();
    }
}
