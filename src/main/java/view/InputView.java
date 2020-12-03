package view;

import domain.Movie;
import domain.MovieController;
import domain.MovieRepository;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Movie getMovie() {
        System.out.println("## 예약할 영화를 선택하세요.");

        try{
            int inputId = Integer.parseInt(getInput());
            return MovieRepository.getMovies().stream()
                    .filter(movie -> movie.isSameId(inputId))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }catch (IllegalArgumentException IAE){
            IAE.printStackTrace(); // 영화 정보 없음 출력
            return getMovie();
        }
    }

    public static int inputTimeId() {
        OutputView.printMsg("## 예약할 시간을 선택하세요.\n");
        return Integer.parseInt(getInput());
    }

    public static int inputPerson() {
        OutputView.printMsg("## 예약할 인원을 선택하세요.\n");
        return Integer.parseInt(getInput());
    }

    public static int askBookMoreOrPay(){
        OutputView.printMsg("## 예약을 종료하고 결제를 진행하려면 1, 추가 2.\n");
        return Integer.parseInt(getInput());
    }

    private static String getInput(){
        return scanner.nextLine();
    }
}
