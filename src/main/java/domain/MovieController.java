package domain;

import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieController {
    private static final int BOOK_MORE_BUTTON = 1;
    private final Payment payment;

    public MovieController(){
        payment = new Payment();
    }

    public void playBookSystem(){
        printMovies();
        do{
            Movie movie = InputView.getMovie();
            PlaySchedule playSchedule = askPlaySchedule(movie);
            int person = askPerson(playSchedule);
            movie.book(playSchedule, person);
            payment.addPrice(movie.getPrice(person));
        }while(checkBookMore());
    }

    private void printMovies(){
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
    }

    private PlaySchedule askPlaySchedule(Movie movie){
        try{
            int timeId = InputView.inputTimeId();
            PlaySchedule playSchedule = movie.getPlayScheduleById(timeId+1);
            return playSchedule;
        }catch (IllegalArgumentException IAE){
            OutputView.printMsg(IAE.getMessage());
            return askPlaySchedule(movie);
        }
    }

    private int askPerson(PlaySchedule playSchedule){
        try{
            int person = InputView.inputPerson();
            playSchedule.checkIsAcceptable(person);
            return person;
        }catch (IllegalArgumentException IAE){
            OutputView.printMsg(IAE.getMessage());
            return askPerson(playSchedule);
        }
    }

    private boolean checkBookMore(){
        return InputView.askBookMoreOrPay() == BOOK_MORE_BUTTON;
    }
}
