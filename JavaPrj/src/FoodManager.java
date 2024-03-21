import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoodManager {

//	static final int MAX = 100;
//	static String[] foodNameList = new String[MAX];
//	static int[] countList = new int[MAX];
//	static String[] expDateList = new String[MAX];
//	static String[] descList = new String[MAX];
	static List<Food> foodList = new ArrayList<>();
	
	static int index = -1;
	static int count = 0;
	
	static Scanner scanner = new Scanner(System.in);

	private static void insertFood() {
		System.out.print("이름:"); 
		String foodName = scanner.next();
		System.out.print("수량:"); 
		int count = scanner.nextInt();
		System.out.print("유통기한:"); 
		String expDate = scanner.next();
		System.out.print("설명:"); String desc = scanner.next();
		foodList.add(new Food(foodName, count, expDate, desc));
	}//end insertFood()

	private static void printFoodList() {
		System.out.println("----------------------------------------");
		System.out.println("이름\t수량\t유통기한\t설명");
		System.out.println("----------------------------------------");
		for(int i=0; i<foodList.size(); i++) {
			Food fd = foodList.get(i);
			System.out.printf("%s\t%d\t%s\t%s\n", fd.getFoodName(), fd.getCount(), fd.getExpDate(), fd.getDesc());
		}
		System.out.println("----------------------------------------");
	}//end printFoodList()


	private static void updateFoodCount() {
		System.out.print("수정할 식자재 이름을 입력하세요:");
		String changeFood = scanner.next();
		for(int i=0; i<foodList.size(); i++) {
			Food fd = foodList.get(i);
			if(fd.getFoodName().equals(changeFood)) {
				System.out.print("수량을 입력하세요:");
				int cnt = scanner.nextInt();
				if(cnt==0) {
					foodList.remove(i);
				}else {
					fd.setCount(cnt);
				}
				System.out.println(fd.getFoodName() + " 식자재가 수정되었습니다.");
				return; //break; 하면 안 됨
			}//end if
		}//end for
		System.out.println("수정할 식자재가 없습니다.");
	}//end updateFoodCount()

	private static void deleteFood() {
		System.out.print("삭제할 식자재 이름을 입력하세요:");
		String food = scanner.next();
		for(int i=0; i<foodList.size(); i++) {
			Food fd = foodList.get(i);
			if(fd.getFoodName().equals(food)) {
				foodList.remove(i);
				return; //break; 하면 안 됨
			}
		}
		System.out.println("삭제할 식자재가 없습니다.");
	}//end deleteFood()



	public static void main(String[] args) {
		while(true) {
			System.out.println("메뉴를 입력하세요.");
			System.out.println("1.추가, 2.목록보기, 3.수정, 4.삭제, 0.종료");
			System.out.print("메뉴:");
			int menu = scanner.nextInt();
			switch(menu) {
			case 1:
				System.out.println("새로운 식자재를 추가합니다.");
				insertFood();
				break;
			case 2:
				System.out.println("식자재 목록을 출력합니다.");
				printFoodList();
				break;
			case 3:
				System.out.println("식자재 정보를 수정합니다.");
				updateFoodCount();
				break;
			case 4:
				System.out.println("식자재 정보를 삭제합니다.");
				deleteFood();
				break;
			case 0:
				System.out.println("식자재 관리 프로그램을 종료합니다.");
				System.exit(0);
			default :
				System.out.println("잘못된 메뉴입니다.");
				break;
			}//end switch
		}//end while

	}//end main
}//end class
