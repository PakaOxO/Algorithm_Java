package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 자료구조는 정말 최고야
public class BaekJoon_23253 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean yn = true;
		for (int i=0; i<M; i++) {
			if (!yn) break;
			int K = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int max = 200000;
			boolean isSorted = true;
			for (int j=0; j<K; j++) {
				int input = Integer.parseInt(st.nextToken());
				if (input > max) {
					isSorted = false;
				} else {
					max = input;
				}
			}
			if (!isSorted) {
				yn = false;
			}
		}
		
		if (yn) System.out.println("Yes");
		else System.out.println("No");
		br.close();
	}

}
