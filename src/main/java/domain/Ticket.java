package domain;

import java.time.LocalDateTime;

public class Ticket {
    private String name;
    private int price;
    private LocalDateTime startTime;
    private int numberOfPeople;

    private Ticket(String name, int price, LocalDateTime time, int count) {
        this.name = name;
        this.numberOfPeople = count;
        this.price = price;
        this.startTime = time;
    }

    public static Ticket create(String name, int price, LocalDateTime time, int count) {
        return new Ticket(name, price, time, count);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }
}
