package domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class PlaySchedules implements Iterable<PlaySchedule> {
    private final List<PlaySchedule> playSchedules;

    public PlaySchedules(){
        playSchedules = new ArrayList<>();
    }

    public PlaySchedule getById(int id){
        PlaySchedule playSchedule = playSchedules.get(id);
        if(playSchedule == null){
            throw new IllegalArgumentException("시간 정보가 없습니다.");
        }
        return playSchedule;
    }

    public void add(PlaySchedule playSchedule) {
        playSchedules.add(playSchedule);
    }

    @Override
    public Iterator<PlaySchedule> iterator() {
        return playSchedules.iterator();
    }
}
