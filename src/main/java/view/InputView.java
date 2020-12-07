package view;

import domain.*;
import utils.InputValidator;

import java.util.Scanner;

public class InputView {
    private static final int EXIT_RESERVATION = 1;
    private static final int MORE_RESERVATION = 2;
    private static final int PAY_WITH_CARD = 1;
    private static final int PAY_WITH_CASH = 2;

    private InputView(){}

    private static final Scanner scanner = new Scanner(System.in);

    public static Movie getMovie() {
        OutputView.printMsg("## 예약할 영화를 선택하세요.\n");
        try{
            int movieId = getInteger();
            InputValidator.checkPositive(movieId);
            return Movies.getMovieById(movieId);
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
        try{
            int numberOfPeople = getInteger();
            InputValidator.checkPositive(numberOfPeople);
            playSchedule.checkAcceptable(numberOfPeople);
            return numberOfPeople;
        }catch (Exception e) {
            OutputView.printMsg(e.getMessage());
            return inputNumberOfPeople(playSchedule);
        }
    }

    public static boolean askTicketingMore(){
        OutputView.printMsg("## 예약을 종료하고 결제를 진행하려면 1, 추가 예약을 진행하시려면 2\n");
        try{
            int answer = getInteger();
            InputValidator.checkValidRange(answer, EXIT_RESERVATION, MORE_RESERVATION);
            if(answer == EXIT_RESERVATION){
                return false;
            }
            return true;
        }catch (Exception e){
            OutputView.printMsg(e.getMessage());
            return askTicketingMore();
        }
    }

    public static int getPoint(){
        OutputView.printMsg("## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0을 입력하세요.\n");
        try{
            int point = getInteger();
            InputValidator.checkPositive(point);
            return point;
        }catch (Exception e) {
            OutputView.printMsg(e.getMessage());
            return getPoint();
        }
    }

    public static int askCardOrCash(){
        OutputView.printMsg("## 신용카드는 1번 현금은 2번을 입력해주세요\n");
        try{
            int answer = getInteger();
            InputValidator.checkValidRange(answer, PAY_WITH_CARD, PAY_WITH_CASH);
            return answer;
        }catch (Exception e){
            OutputView.printMsg(e.getMessage());
            return askCardOrCash();
        }
    }

    private static int getInteger(){
        try{
            return Integer.parseInt(getInput());
        }catch (Exception e){
            OutputView.printMsg("숫자를 입력하세요.\n");
            return getInteger();
        }
    }

    private static String getInput(){
        return scanner.nextLine();
    }
}