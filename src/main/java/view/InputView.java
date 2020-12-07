package view;

import domain.*;
import utils.InputValidator;

import java.util.Scanner;

public class InputView {
    private static final int EXIT_RESERVATION = 1;
    private static final int MORE_RESERVATION = 2;

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