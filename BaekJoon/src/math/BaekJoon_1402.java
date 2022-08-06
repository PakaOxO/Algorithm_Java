package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 아무래도이문제는A번난이도인것같다
public class BaekJoon_1402 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i=1; i<=T; i++) {
			br.readLine();
			sb.append("yes\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
