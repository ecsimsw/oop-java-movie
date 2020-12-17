package utils;

import domain.PlaySchedule;
import domain.Reservations;

public class Validator {

    private Validator(){}

    public static void checkValidCount(PlaySchedule playSchedule, int count){
        if(!playSchedule.isAcceptable(count)){
            throw new IllegalArgumentException("수용 가능 인원이 아닙니다.");
        }
    }

    public static void checkInvalidSchedule(Reservations reservations, PlaySchedule playSchedule){
        if(!reservations.isAcceptableSchedule(playSchedule)){
            throw new IllegalArgumentException("기존에 예매한 영화 내역과 1시간 이상 차이가 날 수 없습니다.");
        }
    }
}
