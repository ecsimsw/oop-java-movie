package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlaySchedules implements Iterable<PlaySchedule>{
    private final List<PlaySchedule> playSchedules;

    public PlaySchedules(){
        playSchedules = new ArrayList<>();
    }

    public PlaySchedule getById(int id){
        PlaySchedule playSchedule = playSchedules.get(id);
        if(playSchedule == null){
            throw new IllegalArgumentException();
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
