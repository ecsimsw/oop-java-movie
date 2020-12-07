package view;

import java.util.Scanner;

public class InputView {
    private InputView(){}

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        try{
            OutputView.printMsg("## 예약할 영화를 선택하세요.\n");
            return getInteger();
        }catch (Exception e){
            return inputMovieId();
        }
    }

    public static int inputTimeId() {
        try{
            OutputView.printMsg("## 예약할 시간를 선택하세요.\n");
            return getInteger();
        }catch (Exception e){
            return inputMovieId();
        }
    }

    public static int inputNumberOfPeople() {
        try{
            OutputView.printMsg("## 예약할 인원을 입력하세요.\n");
            return getInteger();
        }catch (Exception e){
            return inputMovieId();
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
