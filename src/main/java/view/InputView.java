package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAKE_PAYMENT = 1;
    private static final int HAS_ADDITIONAL_BOOKING = 2;

    private InputView() {
    }

    public static int getPoint(int totalPrice){
        OutputView.println("포인트 사용 금액을 입력하세요. 포인트가 없으면 0을 입력하세요");
        int userInput = getInteger();

        if(userInput < 0){
            throw new IllegalArgumentException("포인트는 음수가 될 수 없습니다.");
        }

        if(userInput > totalPrice){
            throw new IllegalArgumentException("사용하는 포인트는 전체 금액을 넘을 수 없습니다.");
        }

        return userInput;
    }

    public static boolean getHasAdditionalBooking(){
        OutputView.println("예약을 종료하고 결제를 진행하려면 1, 추가 예약을 진행하시려면 2");
        int userInput = getInteger();

        if(userInput == MAKE_PAYMENT){
            return false;
        }

        if(userInput == HAS_ADDITIONAL_BOOKING){
            return true;
        }

        throw new IllegalArgumentException("적절하지 않은 입력입니다.");
    }

    public static int getMovieId(){
        OutputView.println("예약할 영화를 선택하세요.");
        return getInteger();
    }
    
    public static int getTimeId(){
        OutputView.println("예약할 시간을 선택하세요.");
        return getInteger();
    }

    public static int getCount(){
        OutputView.println("예약할 인원을 선택하세요.");
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