package domain;

import utils.DateTimeUtils;

import java.time.LocalDateTime;

// 문제 제대로 해석 안함 -> lastTime 필요 없음
public class ReservedTimes {
    private LocalDateTime firstTime;
//    private LocalDateTime lastTime;

    public ReservedTimes() {

    }

    public void checkValidTime(LocalDateTime newTime) {
        if (firstTime == null) {
            return;
        }

//        if (!DateTimeUtils.isOneHourWithinRange(firstTime, newTime)
//                || !DateTimeUtils.isOneHourWithinRange(lastTime, newTime)) {
//            throw new IllegalArgumentException("1시간 이상 차이나는 시간 예약 불가");
//        }

        if (!DateTimeUtils.isOneHourWithinRange(firstTime, newTime)) {
            throw new IllegalArgumentException("1시간 이상 차이나는 시간 예약 불가");
        }
    }

    public void addNew(LocalDateTime newTime) {
        if (firstTime == null) {
            firstTime = newTime;
//            lastTime = newTime;
            return;
        }

        if (newTime.isBefore(firstTime)) {
            firstTime = newTime;
            return;
        }

//        if (newTime.isAfter(lastTime)) {
//            lastTime = newTime;
//            return;
//        }
    }
}
