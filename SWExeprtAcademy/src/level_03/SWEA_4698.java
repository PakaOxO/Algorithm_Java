package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 테네스의 특별한 소수
public class SWEA_4698 {
	static boolean[] isPrime;
	
	static void setPrimeList(int N) {
		isPrime = new boolean[N + 1];
		isPrime[0] = false;
		isPrime[1] = false;
		if (N < 2) return;
		for (int i=2; i<=N; i++) {
			isPrime[i] = true;
		}
		for (int i=2; i*i<=N; i++) {
			if (!isPrime[i]) continue;
			for (int j=i*i; j<=N; j+=i) {
				isPrime[j] = false;
			}
		}
	}
	
	static boolean hasNum(int target, int num) {
		while (target > 0) {
			int n = target % 10;
			if (n == num) return true;
			target /= 10;
		}
		
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			int answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			setPrimeList(B);
			for (int i=A; i<=B; i++) {
				if (!isPrime[i]) continue;
				if (hasNum(i, D)) answer++;
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
