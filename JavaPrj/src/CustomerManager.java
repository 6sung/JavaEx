import java.util.Scanner;

public class CustomerManager {

	//배열에 저장할 수 있는 최대 고객의 수
	static final int MAX = 100;

	//고객 정보를 저장할 변수를 배열로 선언
	static Customer[] custList = new Customer[MAX];
//	static String[] nameList = new String[MAX];	//이름 저장
//	static char[] genderList = new char[MAX];	//성별 저장
//	static String[] emailList = new String[MAX];	//이메일 저장
//	static int[] birthYearList = new int[MAX];	//출생 연도 저장

	//배열은 인덱스가 필요함
	//배열은 0부터 시작하므로 최초 인덱스는 -1이어야 함
	static int index = -1;

	//배열은 처음 선언한 크기보다 같거나 적은 개수의 자료를 저장 
	//그래서 현재 데이터가 몇 개 저장되어 있는지 알 수 있는 변수 선언
	static int count = 0;//개수
	
	//기본 입력장치로부터 데이터를 입력받기 위해 Scanner 객체 생성
	static Scanner scanner = new Scanner(System.in);

	private static void insertCustomer() {
		System.out.print("이름: ");	
		String name = scanner.next();
		System.out.print("성별(M/F): ");	
		char gender = scanner.next().charAt(0);
		System.out.print("이메일: ");	
		String email = scanner.next();
		System.out.print("출생 연도: ");	
		int birthYear = scanner.nextInt();

		//고객 객체를 count 번째 배열에 저장 후 count 값을 증가시켜야 함
//		nameList[count] = name;
//		genderList[count] = gender;
//		emailList[count] = email;
//		birthYearList[count] = birthYear;
		custList[count] = new Customer(name, gender, email, birthYear);
		count++;
	}
	
	//고객데이터 출력
	private static void printCustomer() {
		System.out.println("==========CUSTOMER INFO================");
//		System.out.println("이름: " + nameList[index]);
//		System.out.println("성별: " + genderList[index]);
//		System.out.println("이메일: " + emailList[index]);
//		System.out.println("출생 연도: " + birthYearList[index]);
		Customer cust = custList[index];
		System.out.println("이름: " + cust.getName());
		System.out.println("성별: " + cust.getGender());
		System.out.println("이메일: " + cust.getEmail());
		System.out.println("출생 연도: " + cust.getBirthYear());

	}
	
	//index 위치의 고객 정보를 삭제합니다.
	private static void deleteCustomer() {
		for(int i=index; i<count-1; i++) {
			custList[i] = custList[i+1];
//			nameList[i] = nameList[i+1];
//			genderList[i] = genderList[i+1];
//			emailList[i] = emailList[i+1];
//			birthYearList[i] = birthYearList[i+1];
		}
		count--;
	}
	
	//index 위치의 고객 정보를 수정합니다.
	private static void updateCustomer() {
		Customer cust = custList[index];
		System.out.println("---------UPDATE CUSTOMER INFO----------");
		System.out.print("이름(" + cust.getName() + ") :");
		cust.setName(scanner.next());
		
		System.out.print("성별(" + cust.getGender() + ") :");
		cust.setGender(scanner.next().charAt(0));
		
		System.out.print("이메일(" + cust.getEmail() + ") :");
		cust.setEmail(scanner.next());
		
		System.out.print("출생 연도(" + cust.getBirthYear() + ") :");
		cust.setBirthYear(scanner.nextInt());		
	}

	public static void main(String[] args) {

		while(true) {
			System.out.printf("\n고객 수: %d, 인덱스: %d\n", count, index);
			System.out.println("메뉴를 입력하세요.");
			System.out.println("(I)nsert, (P)revious, (N)ext, " +
					"(C)urrent, (U)pdate, (D)elete, (Q)uit");
			System.out.print("메뉴 입력: ");
			String menu = scanner.next();
			menu = menu.toLowerCase(); //입력한 문자열을 소문자로 변환
			switch(menu.charAt(0)) {
			case 'i':
				System.out.println("고객 정보 입력을 시작합니다.");
				if(count >= MAX) {
					System.out.println("더 이상 입력할 수 없습니다.");
				}else {
					insertCustomer();
					System.out.println("고객 정보를 입력했습니다.");
				}
				break;
			case 'p' :
				System.out.println("이전 데이터를 출력합니다.");
				if(index <= 0) {
					System.out.println("이전 데이터가 없습니다.");
				}else {
					index--;
					printCustomer();
				}
				break;
			case 'n' :
				System.out.println("다음 데이터를 출력합니다.");
				if(index >= count-1) {
					System.out.println("다음 데이터가 없습니다.");
				}else {
					index++;
					printCustomer();
				}
				break;
			case 'c' :
				System.out.println("현재 데이터를 출력합니다.");
				if( (index >= 0) && (index < count)) {
					printCustomer();
				}else {
					System.out.println("데이터가 선택되지 않았습니다.");
				}
				break;			
			case 'u' :
				System.out.println("데이터를 수정합니다.");
				if( (index >= 0) && (index < count)) {
					System.out.println(index + "번째 데이터를 수정합니다.");
					updateCustomer();
				}else {
					System.out.println("데이터가 선택되지 않았습니다.");
				}
				break;
			case 'd' :
				System.out.println("데이터를 삭제합니다.");
				if( (index >= 0) && (index < count)) {
					System.out.println(index + "번째 데이터를 삭제합니다.");
					deleteCustomer();
				}else {
					System.out.println("데이터가 선택되지 않았습니다.");
				}
				break;
			case 'q' :
				System.out.println("프로그램을 종료합니다.");
				scanner.close();		//Scanner 객체를 닫아줍니다.
				System.exit(0);	//프로그램을 종료시킵니다.
			default : 
				System.out.println("메뉴를 잘못 입력했습니다.");
			}//end switch

		}//end while

	}//end main

}//end class