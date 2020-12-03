package view;

import domain.Movie;
import domain.MovieRepository;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Movie getMovie() {
        System.out.println("## 예약할 영화를 선택하세요.");
        try{
            return MovieRepository.getMovieById(getInteger());
        }catch (IllegalArgumentException IAE){
            OutputView.printMsg(IAE.getMessage());
            return getMovie();
        }
    }

    public static int inputTimeId() {
        OutputView.printMsg("## 예약할 시간을 선택하세요.\n");
        return getInteger();
    }

    public static int inputPerson() {
        OutputView.printMsg("## 예약할 인원을 선택하세요.\n");
        return getInteger();
    }

    public static int askBookMoreOrPay(){
        OutputView.printMsg("## 예약을 종료하고 결제를 진행하려면 1, 추가 2.\n");
        return getInteger();
    }

    public static int askPointMoney(){
        OutputView.printMsg("## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0을 입력하세요\n");
        return getInteger();
    }

    public static int askCardOrCash(){
        OutputView.printMsg("## 신용카드는 1번, 현금은 2번을 입력하세요.\n");
        return getInteger();
    }

    private static int getInteger(){
        return scanner.nextInt();
    }

    private static String getInput(){
        return scanner.nextLine();
    }
}
