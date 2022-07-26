package loop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 별 찍기 2
public class BaekJoon_2439 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			for (int j=0; j<N-i-1; j++) {
				sb.append(" ");
			}
			for (int j=0; j<=i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
