package domain;

import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieController {
    public MovieController(){

    }

    public void book(){
        printMovies();

        Movie movie = InputView.getMovie();
        PlaySchedule playSchedule = askPlaySchedule(movie);
        int person = askPerson(playSchedule);
    }

    private void printMovies(){
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
    }

    private PlaySchedule askPlaySchedule(Movie movie){
        PlaySchedule playSchedule = null;
        do{
            int timeId = InputView.inputTimeId();
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
}
