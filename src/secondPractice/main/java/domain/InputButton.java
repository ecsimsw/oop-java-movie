package domain;

public enum InputButton {
    BUTTON_1(1), BUTTON2(2);

    private int buttonNumber;

    InputButton(int input){
        this.buttonNumber = input;
    }
}
