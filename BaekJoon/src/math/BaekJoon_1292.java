package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 쉽게 푸는 문제
public class BaekJoon_1292 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int cnt = 1;
		int sum = 0;
		for (int i=1; cnt<=B; i++) {
			for (int j=0; j<i; j++) {
				if (cnt >= A && cnt <= B) sum += i;
				cnt++;
			}
		}
		System.out.println(sum);
	}

}
