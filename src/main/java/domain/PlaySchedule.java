package domain;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

public class PlaySchedule{
    private final LocalDateTime startDateTime;
    private int capacity;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    public boolean isAcceptable(int numberOfPeople){
        return capacity >= numberOfPeople;
    }

    public LocalDateTime getStartDateTime(){
        return startDateTime;
    }

    public void reduceCapacity(int numberOfReserved){
        capacity -= numberOfReserved;
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }
}
