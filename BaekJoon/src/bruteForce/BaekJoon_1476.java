package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 날짜 계산
public class BaekJoon_1476 {
	static int[] esm = new int[3];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		while (true) {
			esm[0] = ( (esm[0] + 1) % 16 == 0 ) ? 1 : esm[0] + 1;
			esm[1] = ( (esm[1] + 1) % 29 == 0 ) ? 1 : esm[1] + 1;
			esm[2] = ( (esm[2] + 1) % 20 == 0 ) ? 1 : esm[2] + 1;
			cnt++;
			if (esm[0] == E && esm[1] == S && esm[2] == M) break;
		}
		System.out.println(cnt);
		br.close();
	}

}
