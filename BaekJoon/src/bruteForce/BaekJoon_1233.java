package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 주사위
public class BaekJoon_1233 {
	static int[] cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S1 = Integer.parseInt(st.nextToken());
		int S2 = Integer.parseInt(st.nextToken());
		int S3 = Integer.parseInt(st.nextToken());
		
		cnt = new int[S1 + S2 + S3 + 1];
		for (int i=1; i<=S1; i++) {
			for (int j=1; j<=S2; j++) {
				for (int k=1; k<=S3; k++) {
					cnt[i + j + k]++;
				}
			}
		}
		
		int maxIdx = 3;
		for (int i=3; i<cnt.length; i++) {
			if (cnt[i] > cnt[maxIdx]) {
				maxIdx = i;
			}
		}
		System.out.println(maxIdx);
		br.close();
	}

}
