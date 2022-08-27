package heap;

import java.util.*;
import java.io.*;

// 중앙값 구하기 
public class BaekJoon_2696 {
	static PriorityQueue<Integer> pqA;
	static PriorityQueue<Integer> pqB;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			pqA = new PriorityQueue<>((o1, o2) -> o2 - o1);
			pqB = new PriorityQueue<>();
			
			int M = Integer.parseInt(br.readLine());
			StringTokenizer st = null;
			sb.append(M / 2 + 1).append("\n");
			int cnt = 0;
			for (int i=0; i<M; i++) {
				if (i % 10 == 0) st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				if (pqB.size() > 0 && pqB.peek() < num) {
					pqA.add(pqB.poll());
					pqB.add(num);
				} else {
					pqA.add(num);
				}
				
				if (i > 0 && i % 2 == 0) pqB.add(pqA.poll());
				if (i % 2 == 0) {
					sb.append(pqA.peek());
					cnt++;
					if (cnt == 10) {
						sb.append("\n");
						cnt = 0;
					}
					if (cnt != 0 && i < M - 1) sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
