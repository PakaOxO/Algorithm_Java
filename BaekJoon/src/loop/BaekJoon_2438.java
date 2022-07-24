package loop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 별 찍기 - 1
public class BaekJoon_2438 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder star = new StringBuilder();
		StringBuilder result = new StringBuilder();
		for (int i=0; i<N; i++) {
			star.append("*");
			result.append(star + "\n");
		}
		System.out.println(result);
		br.close();
	}

}
