import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;
import java.io.InputStream;
import java.io.FileInputStream;

public class FileIOExample {
	public static void main(String[] args) throws Exception{
		OutputStream os = new FileOutputStream("test1.txt");
		String str = new String("Hello");
		byte[] bytes = str.getBytes();
		os.write(bytes);
		os.close();
		System.out.println("파일에 저장되었습니다.");
		
		Writer out = new FileWriter("test2.txt");
		out.write("안녕하세요. 반갑습니다.");
		out.close();
		System.out.println("파일에 저장되었습니다.");
		System.out.println("---------------------");
		InputStream is = new FileInputStream("test1.txt");
		byte[] buffer = new byte[3];
		int readCount = 0;
		StringBuilder sb = new StringBuilder();
		while(readCount >= 0) {
			String s1 = new String(buffer,0,readCount);
			sb.append(s1);
			readCount = is.read(buffer);
		}
		System.out.println(sb.toString());
		is.close();
		//System.out.println(new String(buffer, 0, readCount));
		
	}
}
