package bruteForce;

import java.io.*;

/**
 * BaekJoon_12919, A와 B 2
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 완전 탐색을 진행하면서 A를 뒤에 추가할 지, B를 추가하고 뒤집을 지 선택할 수 있는 방법 탐색
 * 	2. 탐색은 문자열 S의 길이가 T와 같게 되는 시점까지
 * 	3. 문자열 길이가 같게 되었을 때 두 문자열 비교
 *
 */
public class BaekJoon_12919 {
	static boolean flag;
	
	static void dfs(String s, String t) {
		StringBuilder sb = new StringBuilder(s);
		if (!(t.indexOf(s) != -1 || t.indexOf(sb.reverse().toString()) != -1)) return;
		if (s.length() == t.length()) {
			if (s.equals(t)) flag = true;
			return; 
		}
		
		dfs(s + "A", t);
		sb = new StringBuilder(s);
		sb.append("B");
		dfs(sb.reverse().toString(), t);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		
		dfs(S, T);
		if (flag) System.out.println(1);
		else System.out.println(0);
		br.close();
	}

}
