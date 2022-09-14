package math;

import java.io.*;

/**
 * 팩토리얼
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 팩토리얼 계산의 시간복잡도는 N
 * 	2. N!을 (N * 1) * ((N - 1) * 2) * ((N - 2) * 3) ...으로 하면 시간복잡도를 절반으로 줄일 수 있음
 * 	3. N - i 와 i + 1 이 같아지면 stop
 * 
 */
public class BaekJoon_10872 {
	static int factorial(int n) {
		int f = 1;
		int i = 0;
		while (n - i >= i + 1) {
			if (n - i == i + 1) {
				f *= n - i;
				break;
			}
			f *= (n - i) * (i + 1);
			i++;
		}
		return f;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(factorial(N));
		br.close();
	}

}
