package domain;

public class Payment {
    private int price;

    public Payment(){
        price = 0;
    }

    public void addPrice(int addition){
        price += addition;
    }
}
