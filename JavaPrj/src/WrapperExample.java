
public class WrapperExample {
	public static void main(String[] args) {
		Integer i1 = 100; // 오토 박싱
		int i2 = i1; // 오토 언박싱
		Integer i3 = Integer.parseInt("100");
		int i4 = 100;
		
		int data1 = 2000;
		int data2 = 2000;
		System.out.println(data1 == data2);
		
		Integer data3 = 1000;
		Integer data4 = 1000;
		System.out.println(data3 == data4);
		
		Integer data5 = 100;
		Integer data6 = 100;
		System.out.println(data5 == data6);
		
	}
}
