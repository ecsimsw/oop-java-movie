package utils;

public class InputValidator {
    private InputValidator(){}

    public static void checkNumberInRange(int input, int min, int max){
        if(input < min || input > max){
            throw new IllegalArgumentException("잘못된 입력입니다. 입력 범위를 확인하여 주시길 바랍니다.\n");
        }
    }

    public static void checkNumberSmallThan(int input, int underLimit){
        if(input < underLimit){
            throw new IllegalArgumentException("잘못된 입력입니다. 입력 범위를 확인하여 주시길 바랍니다.\n");
        }
    }
}
