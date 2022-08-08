package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 나머지와 몫이 같은 수
public class BaekJoon_1834 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Integer.parseInt(br.readLine());
		System.out.println((N + 1) * (N - 1) * N / 2);
		br.close();
	}

}
