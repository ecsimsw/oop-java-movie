package domain;

import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieController {
    private static final int BOOK_MORE_BUTTON = 1;

    public MovieController(){

    }

    public void playBookSystem(){
        printMovies();
        do{
            bookOneMovie();
        }while(checkBookMore());
    }

    private void printMovies(){
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
    }

    public void bookOneMovie(){
        Movie movie = InputView.getMovie();
        PlaySchedule playSchedule = askPlaySchedule(movie);
        int person = askPerson(playSchedule);

        movie.book(playSchedule, person);
        movie.getPrice(person);
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
