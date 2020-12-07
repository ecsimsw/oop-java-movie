package domain;

import java.time.LocalDateTime;

public class ReservedInfo {
    private String name;
    private int price;
    private LocalDateTime startTime;
    private int numberOfPeople;

    private ReservedInfo(String name, int price, LocalDateTime time, int count){
        this.name= name;
        this.numberOfPeople = count;
        this.price = price;
        this.startTime = time;
    }

    public static ReservedInfo create(String name, int price, LocalDateTime time, int count){
        return new ReservedInfo(name, price, time, count);
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public LocalDateTime getStartTime(){
        return startTime;
    }

    public int getNumberOfPeople(){
        return numberOfPeople;
    }
}
