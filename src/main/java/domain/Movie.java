package domain;

import java.util.List;
import java.util.ArrayList;

public class Movie {
    private static final char NEW_LINE = '\n';

    private final int id;
    private final String name;
    private final int price;

    private List<PlaySchedule> playSchedules = new ArrayList<>();

    public Movie(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    void addPlaySchedule(PlaySchedule playSchedule) {
        playSchedules.add(playSchedule);
    }

    public PlaySchedule getPlayScheduleByIndex(int index){
        return playSchedules.get(index-1);
    }

    public boolean isId(int id){
        return this.id == id;
    }

    public String getName(){
        return this.name;
    }

    public int getPrice(){
        return this.price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PlaySchedule playSchedule : playSchedules) {
            sb.append(playSchedule);
        }
        return id + " - " + name + ", " + price + "원" + NEW_LINE
                + sb.toString();
    }
}