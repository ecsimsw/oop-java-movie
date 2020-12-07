package domain;

import utils.DateTimeUtils;

import java.time.LocalDateTime;

public class ReservedTimes {
    private LocalDateTime firstTime;
    private LocalDateTime lastTime;

    public ReservedTimes() {

    }

    public void checkValidTime(LocalDateTime newTime) {
        if (firstTime == null) {
            return;
        }

        if (!DateTimeUtils.isOneHourWithinRange(firstTime, newTime)
                || !DateTimeUtils.isOneHourWithinRange(lastTime, newTime)) {
            throw new IllegalArgumentException("1시간 이상 차이나는 시간 예약 불가");
        }
    }

    public void addNew(LocalDateTime newTime) {
        if (firstTime == null) {
            firstTime = newTime;
            lastTime = newTime;
            return;
        }

        if (newTime.isBefore(firstTime)) {
            firstTime = newTime;
            return;
        }

        if (newTime.isAfter(lastTime)) {
            lastTime = newTime;
            return;
        }
    }
}
