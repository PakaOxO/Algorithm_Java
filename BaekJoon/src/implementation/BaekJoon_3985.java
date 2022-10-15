package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 롤 케이크
public class BaekJoon_3985 {
	static StringTokenizer st;
	static boolean[] isOwned;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		isOwned = new boolean[L];
		int N = Integer.parseInt(br.readLine());
		int expected = -1, result = -1;
		int answer1 = -1, answer2 = -1;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			
			if (to - from + 1 > expected) {
				expected = to - from + 1;
				answer1 = i + 1;
			}
			
			int rCnt = 0;
			for (int j=from; j<=to; j++) {
				if (!isOwned[j]) {
					isOwned[j] = true;
					rCnt++;
				}
			}
			if (rCnt > result) {
				result = rCnt;
				answer2 = i + 1;
			}
		}
		System.out.println(answer1);
		System.out.println(answer2);
		br.close();
	}

}
