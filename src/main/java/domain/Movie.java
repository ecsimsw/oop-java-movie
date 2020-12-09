package domain;

public class Movie {
    private static final char NEW_LINE = '\n';

    private final int id;
    private final String name;
    private final int price;

    private PlaySchedules playSchedules;

    public Movie(int id, String name, int price) {
        playSchedules = new PlaySchedules();
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void addPlaySchedule(PlaySchedule playSchedule) {
        playSchedules.add(playSchedule);
    }

    public boolean isId(int id) {
        return this.id == id;
    }

    public PlaySchedule getScheduleById(int id) {
        return playSchedules.getById(id);
    }

    public int calculatePrice(int numberOfPeople) {
        return price * numberOfPeople;
    }

    public Ticket reserve(PlaySchedule playSchedule, int numberOfPeople) {
        playSchedule.reduceCapacity(numberOfPeople);
        return Ticket.create(name, price, playSchedule.getStartDateTime(), numberOfPeople);
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