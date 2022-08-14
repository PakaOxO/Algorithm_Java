package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 설탕 배달
public class BaekJoon_2839 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = -1;
		
		int cnt5 = N / 5;
		while (cnt5 >= 0) {
			int res = N - (cnt5 * 5);
			if (res % 3 == 0) {
				answer = cnt5 + (res / 3);
				break;
			}
			cnt5--;
		}
		System.out.println(answer);
		br.close();
	}

}
