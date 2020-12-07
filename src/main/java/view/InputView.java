package view;

import domain.Movie;
import domain.MovieRepository;
import domain.Movies;
import domain.PlaySchedule;

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

    public static PlaySchedule getSchedule(Movie movie) {
        try{
            OutputView.printMsg("## 예약할 시간를 선택하세요.\n");
            return movie.getScheduleById( getInteger());
        }catch (Exception e){
            OutputView.printMsg("존재하지 않는 시간 번호입니다. \n");
            return getSchedule(movie);
        }
    }

    public static int inputNumberOfPeople(PlaySchedule playSchedule) {
        OutputView.printMsg("## 예약할 인원을 입력하세요.\n");
        int numberOfPeople = getInteger();
        if(playSchedule.isAcceptable(numberOfPeople)){
            return numberOfPeople;
        }
        return inputNumberOfPeople(playSchedule);
    }

    public static boolean askTicketingMore(){
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
