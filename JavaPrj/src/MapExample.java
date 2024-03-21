import java.util.HashMap;
import java.util.Map;

public class MapExample {
	public static void main(String[] args) {
		Map<String, Emp> myMap = new HashMap<>();
		
		myMap.put("foo", new Emp("1111", "Foo", 12345));
		myMap.put("bar", new Emp("1245", "Bar", 11123));
		myMap.put("baz", new Emp("2311", "Baz", 22222));
		
		Emp emp = myMap.get("foo");
		System.out.println(emp);
		
		for(Map.Entry<String, Emp> entry : myMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		System.out.println("----------------------------------------------------");
		
		for(String key : myMap.keySet()) {
			System.out.println(key + " " + myMap.get(key));
		}
	}
}
