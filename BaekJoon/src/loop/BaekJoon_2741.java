package loop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// N 찍기
public class BaekJoon_2741 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=N; i++) {
			sb.append(i + "\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
