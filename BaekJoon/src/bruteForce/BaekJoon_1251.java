package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

// 단어 나누기
public class BaekJoon_1251 {
	static Set<String> set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		
		set = new TreeSet<>();
		for (int i=1; i<len-1; i++) {
			for (int j=i+1; j<len; j++) {
				StringBuilder sb1 = new StringBuilder();
				sb1.append(str.substring(0, i));
				StringBuilder sb2 = new StringBuilder();
				sb2.append(str.substring(i, j));
				StringBuilder sb3 = new StringBuilder();
				sb3.append(str.substring(j, len));
				set.add(sb1.reverse().append(sb2.reverse()).append(sb3.reverse()).toString());
			}
		}
		
		System.out.println(set.iterator().next());
		br.close();
	}

}
