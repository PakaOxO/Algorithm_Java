import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Person implements Comparable<Object> {
	int id;
	String name;
	
	Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public int compareTo(Object obj) {
		return this.id - ((Person)obj).id;
	}
	
	@Override
	public String toString() {
		return "id : " + this.id + ", name : " + name + " / ";
	}
}

public class CollectionsTest {

	public static void main(String[] args) {
		Set<String> mySet = new HashSet<>();
		mySet.add("이순신");
		System.out.println(mySet.remove("이순"));
		
		List<String> myList = new ArrayList<>();
		myList.add("이순신");
		System.out.println(myList.remove("이순신"));
		
		Map<Integer, String> myMap = new HashMap<>();
		myMap.put(100, "이순신");
		System.out.println(myMap.keySet() instanceof HashSet);
		System.out.println(myMap.values() instanceof Collection);
		System.out.println(myMap.entrySet() instanceof HashSet);
	}

}
