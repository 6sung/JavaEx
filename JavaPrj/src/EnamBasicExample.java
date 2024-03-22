
public class EnamBasicExample {
	public static void main(String[] arsg) {
		Coin coin = Coin.NICKEL;
		System.out.println(coin);
		System.out.println(coin.getValue());
		
		buy(coin);
	}
		
	public static void buy(int coin) {
		System.out.println("구매 완료");
	}//레거시
	
	public static void buy(Coin coin) {
		buy(coin.getValue());
		System.out.println("구매 완료2");
	} // 신규 기능
	
		
//		Coin coin = Coin.DIME;
//		
//		switch(coin) {
//		case PENNY:
//			System.out.println("1센트 동전입니다.");
//			break;
//		case NICKEL:
//			System.out.println("5센트 동전입니다.");
//			break;
//		case DIME:
//			System.out.println("10센트 동전입니다.");
//			break;
//		case QUARTER:
//			System.out.println("25센트 동전입니다.");
//			break;
//		default :
//			break;
//		}
}
