package math;

import java.io.*;

/**
 * BaekJoon_1676, 팩토리얼 0의 개수
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 1 ~ N까지의 숫자 중에 5 개수(25의 경우 2개)를 구함
 * 	2. 2의 개수 > 5의 개수이므로 5의 개수를 구하면 2 * 5 = 10이므로 0의 개수 도출 가능
 *
 */
public class BaekJoon_1676 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt5 = 0;
		for (int i=5; i<=N; i+=5) {
			int num = i;
			while (num % 5 == 0) {
				cnt5++;
				num /= 5;
			}
		}
		System.out.println(cnt5);
		br.close();
	}

}
