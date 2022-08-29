package greedy;

import java.io.*;
import java.util.*;

// 라면 사기 (Large)
public class BaekJoon_18186 {
	static int N, B, C;
	static int[] cnt;
	static long price;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		cnt = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			cnt[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx = 0;
		while (idx < N) {
			while (cnt[idx] > 0) {
				cnt[idx]--;
				price += B;
				if (idx + 1 < N && cnt[idx + 1] > 0) {
					cnt[idx + 1]--;
					price += C;
					if (idx + 2 < N && cnt[idx + 2] > 0) {
						cnt[idx + 2]--;
						price += C;
					}
				}
			}
			idx++;
		}
		System.out.println(price);
		br.close();
	}

}
