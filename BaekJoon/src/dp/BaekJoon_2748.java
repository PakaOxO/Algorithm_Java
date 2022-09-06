package dp;

import java.io.*;

/**
 * BaekJoon_2748, 피보나치 수 2
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 입력받은 N으로 N + 1 크기의 fibonachi 배열을 만든다.
 * 		1.1 입력값 N의 최대값은 90이므로 int 배열의 경우 오버플로우가 발생할 수 있으므로 long 타입 배열로 생성
 * 	2. 0, 1 위치에 각각 0, 1 값을 세팅한다.
 * 	3. 나머지 값은 f(n) = f(n - 1) + f(n - 2)를 이용해 값을 얻어낸다.
 *
 */
public class BaekJoon_2748 {
	static long[] fibonachi;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		fibonachi = new long[N + 1];
		fibonachi[0] = 0;
		fibonachi[1] = 1;
		for (int i=2; i<=N; i++) {
			fibonachi[i] = fibonachi[i - 1] + fibonachi[i - 2];
		}
		
		System.out.println(fibonachi[N]);
		br.close();
	}

}
