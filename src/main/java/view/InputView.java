package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    private static int getInteger() {
        try {
            return Integer.parseInt(getInput());
        } catch (Exception e) {
            OutputView.printMsg("숫자를 입력하세요.\n");
            return getInteger();
        }
    }

    private static String getInput() {
        return scanner.nextLine();
    }
}