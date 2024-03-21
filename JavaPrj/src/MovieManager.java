import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieManager {

	static List<Movie> movieList = new ArrayList<>();
	
	static int index = -1;
	//static int count = 0;
	
	static Scanner scanner = new Scanner(System.in);

	private static void insertMovie() {
		System.out.print("제목 : ");
		String movieName = scanner.next();
		System.out.print("장르 : ");
		String movieGenre = scanner.next();
		System.out.print("감독 : ");
		String movieMan = scanner.next();
		System.out.print("주연 : ");
		String movieActor = scanner.next();
		System.out.print("개봉일 : ");
		String movieDate = scanner.next();
		
		movieList.add(new Movie(movieName, movieGenre, movieMan, movieActor, movieDate));
		
	}

	private static void printMovieList() {
		System.out.println("-----------------------------------------------");
		System.out.println("제목\t장르\t감독\t주연\t개봉일");
		System.out.println("-----------------------------------------------");
		for(int i=0; i<movieList.size(); i++) {
			Movie mv = movieList.get(i);
			System.out.printf("%s\t%s\t%s\t%s\t%s\n", mv.getName(), mv.getGenre(), mv.getManager(), mv.getActor(), mv.getStartDate());
		}
		System.out.println("-----------------------------------------------");
	}


	private static void updateMovie() {
		System.out.print("수정할 영화 이름을 입력하세요:");
		String changeMovie = scanner.next();
		for(int i=0; i<movieList.size(); i++) {
			Movie mv = movieList.get(i);
			if(mv.getName().equals(changeMovie)) {
				System.out.print("장르를 입력하세요 : ");
				String newGenre = scanner.next();
				mv.setGenre(newGenre);
				
				System.out.print("감독을 입력하세요 : ");
				String newManager = scanner.next();
				mv.setManager(newManager);
				
				System.out.print("주연을 입력하세요 : ");
				String newActor = scanner.next();
				mv.setActor(newActor);
				
				System.out.print("개봉일을 입력하세요 : ");
				String newDate = scanner.next();
				mv.setStartDate(newDate);
				
				System.out.println(mv.getName() + " 영화 정보가 수정되었습니다.");
				return;
			}
		}
		System.out.println("수정할 영화가 없습니다.");
	}

	private static void deleteMovie() {
		System.out.print("삭제할 영화 제목을 입력하세요 : ");
		String movie = scanner.next();
		for(int i=0; i<movieList.size(); i++) {
			Movie mv = movieList.get(i);
			if(mv.getName().equals(movie)) {
				movieList.remove(i);
				return;
			}
		}
		System.out.println("해당하는 영화는 없습니다.");
	}
	
	private static void findMovie() {
		System.out.print("검색할 영화 장르를 입럭하세요 : ");
		String genre = scanner.next();
		int cnt = 1;
		for(int i=0; i<movieList.size();i++) {
			Movie mv = movieList.get(i);
			if(mv.getGenre().equals(genre)){
				cnt = 0;
				System.out.printf("%s\t%s\t%s\t%s\t%s\n", mv.getName(), mv.getGenre(), mv.getManager(), mv.getActor(), mv.getStartDate());
			}
		}
		if(cnt == 1) System.out.println("해당하는 영화는 없습니다.");
	}



	public static void main(String[] args) {
		while(true) {
			System.out.println("메뉴를 입력하세요.");
			System.out.println("(i)입력, (u)수정, (d)삭제, (f)장르로 영화찾기, (l)전체 목록 출력, (q)종료");
			System.out.print("메뉴:");
			String menu = scanner.next();
			switch(menu.charAt(0)) {
			case 'i':
				System.out.println("새로운 영화를 추가합니다.");
				insertMovie();
				break;
			case 'u':
				System.out.println("영화 정보를 수정합니다.");
				updateMovie();
				break;
			case 'd':
				System.out.println("영화 정보를 삭제합니다.");
				deleteMovie();
				break;
			case 'f':
				System.out.println("장르로 영화를 검색합니다.");
				findMovie();
				break;
			case 'l':
				System.out.println("영화 목록을 출력합니다.");
				printMovieList();
				break;
			case 'q':
				System.out.println("영화 관리 프로그램을 종료합니다.");
				System.exit(0);
			default :
				System.out.println("잘못된 메뉴입니다.");
				break;
			}
		}

	}
}