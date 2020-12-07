package domain;

import view.InputView;
import view.OutputView;

public class Reservation {
    private Movie movie;
    private PlaySchedule playSchedule;

    public Reservation(){
        movie = InputView.getMovie();
        playSchedule = askPlaySchedule(movie);
    }

    public int calculatePrice(){
        int person = askPerson(playSchedule);
        seatReservation(person);
        return movie.calculatePrice(person);
    }

    public void seatReservation(int person){
        playSchedule.updateCapacity(person);
    }

    private PlaySchedule askPlaySchedule(Movie movie) {
        try {
            int timeId = InputView.inputTimeId();
            PlaySchedule playSchedule = movie.getPlayScheduleById(timeId + 1);
            return playSchedule;
        } catch (IllegalArgumentException IAE) {
            OutputView.printMsg(IAE.getMessage());
            return askPlaySchedule(movie);
        }
    }

    private int askPerson(PlaySchedule playSchedule) {
        try {
            int person = InputView.inputPerson();
            playSchedule.checkIsAcceptable(person);
            return person;
        } catch (IllegalArgumentException IAE) {
            OutputView.printMsg(IAE.getMessage());
            return askPerson(playSchedule);
        }
    }

}
