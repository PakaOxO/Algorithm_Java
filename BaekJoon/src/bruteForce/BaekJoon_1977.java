package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 완전제곱수
public class BaekJoon_1977 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i=(int)Math.sqrt(A); i<=(int)Math.sqrt(B); i++) {
			int p = i * i;
			if (p >= A && p <= B) {
				min = Math.min(min, p);
				sum += p;
			}
		}
		if (sum == 0) System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
		br.close();
	}

}
