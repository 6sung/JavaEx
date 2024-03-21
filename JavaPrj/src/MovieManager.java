import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieManager {

	static List<Movie> movieList = new ArrayList<>();
	
	static int index = -1;
	//static int count = 0;
	
	static Scanner scanner = new Scanner(System.in);

	private static void insertMovie() {
		System.out.print("���� : ");
		String movieName = scanner.next();
		System.out.print("�帣 : ");
		String movieGenre = scanner.next();
		System.out.print("���� : ");
		String movieMan = scanner.next();
		System.out.print("�ֿ� : ");
		String movieActor = scanner.next();
		System.out.print("������ : ");
		String movieDate = scanner.next();
		
		movieList.add(new Movie(movieName, movieGenre, movieMan, movieActor, movieDate));
		
	}

	private static void printMovieList() {
		System.out.println("-----------------------------------------------");
		System.out.println("����\t�帣\t����\t�ֿ�\t������");
		System.out.println("-----------------------------------------------");
		for(int i=0; i<movieList.size(); i++) {
			Movie mv = movieList.get(i);
			System.out.printf("%s\t%s\t%s\t%s\t%s\n", mv.getName(), mv.getGenre(), mv.getManager(), mv.getActor(), mv.getStartDate());
		}
		System.out.println("-----------------------------------------------");
	}


	private static void updateMovie() {
		System.out.print("������ ��ȭ �̸��� �Է��ϼ���:");
		String changeMovie = scanner.next();
		for(int i=0; i<movieList.size(); i++) {
			Movie mv = movieList.get(i);
			if(mv.getName().equals(changeMovie)) {
				System.out.print("�帣�� �Է��ϼ��� : ");
				String newGenre = scanner.next();
				mv.setGenre(newGenre);
				
				System.out.print("������ �Է��ϼ��� : ");
				String newManager = scanner.next();
				mv.setManager(newManager);
				
				System.out.print("�ֿ��� �Է��ϼ��� : ");
				String newActor = scanner.next();
				mv.setActor(newActor);
				
				System.out.print("�������� �Է��ϼ��� : ");
				String newDate = scanner.next();
				mv.setStartDate(newDate);
				
				System.out.println(mv.getName() + " ��ȭ ������ �����Ǿ����ϴ�.");
				return;
			}
		}
		System.out.println("������ ��ȭ�� �����ϴ�.");
	}

	private static void deleteMovie() {
		System.out.print("������ ��ȭ ������ �Է��ϼ��� : ");
		String movie = scanner.next();
		for(int i=0; i<movieList.size(); i++) {
			Movie mv = movieList.get(i);
			if(mv.getName().equals(movie)) {
				movieList.remove(i);
				return;
			}
		}
		System.out.println("�ش��ϴ� ��ȭ�� �����ϴ�.");
	}
	
	private static void findMovie() {
		System.out.print("�˻��� ��ȭ �帣�� �Է��ϼ��� : ");
		String genre = scanner.next();
		int cnt = 1;
		for(int i=0; i<movieList.size();i++) {
			Movie mv = movieList.get(i);
			if(mv.getGenre().equals(genre)){
				cnt = 0;
				System.out.printf("%s\t%s\t%s\t%s\t%s\n", mv.getName(), mv.getGenre(), mv.getManager(), mv.getActor(), mv.getStartDate());
			}
		}
		if(cnt == 1) System.out.println("�ش��ϴ� ��ȭ�� �����ϴ�.");
	}



	public static void main(String[] args) {
		while(true) {
			System.out.println("�޴��� �Է��ϼ���.");
			System.out.println("(i)�Է�, (u)����, (d)����, (f)�帣�� ��ȭã��, (l)��ü ��� ���, (q)����");
			System.out.print("�޴�:");
			String menu = scanner.next();
			switch(menu.charAt(0)) {
			case 'i':
				System.out.println("���ο� ��ȭ�� �߰��մϴ�.");
				insertMovie();
				break;
			case 'u':
				System.out.println("��ȭ ������ �����մϴ�.");
				updateMovie();
				break;
			case 'd':
				System.out.println("��ȭ ������ �����մϴ�.");
				deleteMovie();
				break;
			case 'f':
				System.out.println("�帣�� ��ȭ�� �˻��մϴ�.");
				findMovie();
				break;
			case 'l':
				System.out.println("��ȭ ����� ����մϴ�.");
				printMovieList();
				break;
			case 'q':
				System.out.println("��ȭ ���� ���α׷��� �����մϴ�.");
				System.exit(0);
			default :
				System.out.println("�߸��� �޴��Դϴ�.");
				break;
			}
		}

	}
}