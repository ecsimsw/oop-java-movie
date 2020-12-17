package utils;

public class InputValidator {
    private InputValidator() {
    }

    public static void checkValidRange(int input, int min, int max) {
        if (input < min || input > max) {
            throw new IllegalArgumentException("유효하지 않은 범위의 입력입니다.");
        }
    }

    public static void checkPositive(int input) {
        if (input < 0) {
            throw new IllegalArgumentException("숫자는 양수만 입력 가능합니다.");
        }
    }
}
