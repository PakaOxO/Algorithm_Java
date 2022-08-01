package loop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 더하기 사이클
public class BaekJoon_1110 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int prev = N;
		int answer = 0;
		while (true) {
			answer++;
			int num = prev;
			int sum = 0;
			while (num > 0) {
				sum += (num % 10);
				num /= 10;
			}
			int next = (prev % 10) * 10 + (sum % 10);
			if (next == N) break; 
			prev = next;
		}
		System.out.println(answer);
	}

}
