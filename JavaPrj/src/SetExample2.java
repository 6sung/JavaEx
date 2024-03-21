import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExample2 {
	public static void main(String[] args) {
		Set<String> strSet = new HashSet<>();
		strSet.add("Hello");
		strSet.add("World");
		System.out.println(strSet.add("Hello"));
		System.out.println(strSet);
		
		for(String str : strSet) {
			System.out.println(str);
		}
		
		Iterator<String> it = strSet.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		Set<Emp> empSet = new HashSet<>();
		empSet.add(new Emp("1123", "Joe", 100000));
		empSet.add(new Emp("1123", "Joe", 100000));
		empSet.add(new Emp("4132", "Foo", 200000));
		
		System.out.println(empSet);
	}
}
