package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 직사각형을 만드는 방법
public class BaekJoon_8320 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = N;
		for (int i=2; i<=N; i++) {
			if (N / i < i) break;
			answer += N / i - (i - 1);
		}
		System.out.println(answer);
		br.close();
	}

}
