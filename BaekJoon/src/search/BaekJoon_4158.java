package search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// CD
public class BaekJoon_4158 {
	static Set<Integer> set;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0) break;
			set = new HashSet<>();
			for (int i=0; i<N; i++) {
				set.add(Integer.parseInt(br.readLine()));
			}
			// 이진 탐색
			answer = 0;
			for (int j=0; j<M; j++) {
				int cd = Integer.parseInt(br.readLine());
				if (set.contains(cd)) answer++;
			}
			System.out.println(answer);
		}
	}

}
