package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int getMovieId(){
        OutputView.println("예약할 영화를 선택하세요.");
        return getInteger();
    }

    private static int getInteger() {
        try {
            return Integer.parseInt(getInput());
        } catch (Exception e) {
            OutputView.println("정수 범위의 숫자를 입력하세요.");
            return getInteger();
        }
    }

    private static String getInput() {
        return scanner.nextLine();
    }
}