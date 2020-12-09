package domain;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

public class PlaySchedule {
    private final LocalDateTime startDateTime;
    private int capacity;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    public void checkAcceptable(int numberOfPeople) {
        if (capacity < numberOfPeople) {
            throw new IllegalArgumentException("가능 인원 초과입니다.");
        }
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    // 메소드 자체에서 numberOfPeople는 어떤 값일지 전혀 모르는 상황이므로
    // 예외 처리 필요
    public void reduceCapacity(int numberOfPeople) {
        if(capacity - numberOfPeople < 0){
            throw new IllegalArgumentException("잘못된 예약 죄석 수 입니다.");
        }
        capacity -= numberOfPeople;
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }
}
