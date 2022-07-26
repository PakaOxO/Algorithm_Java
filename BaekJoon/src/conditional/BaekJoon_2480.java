package conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 주사위 세개
public class BaekJoon_2480 {
	private static int[] cnt = new int[6];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<3; i++) {
			cnt[Integer.parseInt(st.nextToken()) - 1]++;
		}
		
		int maxCnt = 0;
		int idx = 0;
		for (int i=0; i<6; i++) {
			if (cnt[i] >= maxCnt) {
				maxCnt = cnt[i];
				idx = i;
			}
		}
		
		int answer;
		if (maxCnt == 3) {
			answer = (10000 + (1000 * (idx + 1)));
		} else if (maxCnt == 2) {
			answer = (1000 + (100 * (idx + 1)));
		} else {
			answer = (100 * (idx + 1));
		}
		System.out.println(answer);
	}

}
