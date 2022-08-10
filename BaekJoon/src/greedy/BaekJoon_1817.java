package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 짐 챙기는 숌
public class BaekJoon_1817 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int res = M;
		int result = 1;
		if (N > 0) {
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				int book = Integer.parseInt(st.nextToken());
				if (res >= book) {
					res -= book;
				} else {
					res = M - book;
					result++;
				}
			}
			System.out.println(result);
		} else {
			System.out.println(0);
		}
		br.close();
	}

}
