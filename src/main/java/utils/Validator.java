package utils;

import domain.PlaySchedule;

public class Validator {

    private Validator(){}

    public static void checkValidCount(PlaySchedule playSchedule, int count){
        if(!playSchedule.isAcceptable(count)){
            throw new IllegalArgumentException("수용 가능 인원이 아닙니다.");
        }
    }
}
