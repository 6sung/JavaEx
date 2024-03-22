
public enum Coin {
	PENNY(1),
	NICKEL(5),
	DIME(10),
	QUARTER(25);
	
	private int value;
	
	Coin(int value){
		this.value = value;
	}
	
	int getValue() {
		return value;
	}
}
