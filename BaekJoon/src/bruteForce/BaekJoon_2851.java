package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 슈퍼마리오 
public class BaekJoon_2851 {
	static int[] points;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		points = new int[10];
		for (int i=0; i<10; i++) {
			points[i] = Integer.parseInt(br.readLine());
		}
		int answer = 0;
		for (int i=0; i<10; i++) {
			answer += points[i];
			if (answer > 100) {
				answer = ( answer - 100 <= 100 - answer + points[i] ) ? answer : answer - points[i];
				break;
			}
		}
		System.out.println(answer);
		br.close();
	}

}
