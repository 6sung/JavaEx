
public class StringExample {
	public static void main(String[] args) throws Exception {
		byte[] buffer = new byte[100];
		System.out.print("입력 : ");
		int readCount = System.in.read(buffer);
		System.out.println(readCount);
		System.out.println(buffer);
		String input = new String(buffer,0,readCount);
		System.out.println(input);
	}
}
