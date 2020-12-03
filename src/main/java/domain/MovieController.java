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

    public void bookOneMovie(){
        Movie movie = InputView.getMovie();
        PlaySchedule playSchedule = askPlaySchedule(movie);
        int person = askPerson(playSchedule);

        movie.book(playSchedule, person);
        movie.getPrice(person);
    }

    private void printMovies(){
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
    }

    private PlaySchedule askPlaySchedule(Movie movie){
        PlaySchedule playSchedule;
        int timeId;
        do{
            timeId = InputView.inputTimeId();
            playSchedule = movie.getPlayScheduleById(timeId+1);
            // 없는 스케줄 번호 에러 출력
        }while(playSchedule == null);
        return playSchedule;
    }

    private int askPerson(PlaySchedule playSchedule){
        int person = InputView.inputPerson();
        try{
            playSchedule.checkAcceptable(person);
            return person;
        }catch (IllegalArgumentException IAE){
            IAE.printStackTrace();
            return askPerson(playSchedule);
        }
    }

    private boolean checkBookMore(){
        if(InputView.askBookMoreOrPay() == BOOK_MORE_BUTTON){
            return true;
        }
        return false;
    }
}
