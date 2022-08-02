package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// 나머지
public class BaekJoon_3052 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> mySet = new HashSet<>();
		for (int i=0; i<10; i++) {
			mySet.add(Integer.parseInt(br.readLine())% 42);
		}
		System.out.println(mySet.size());
		br.close();
	}

}
