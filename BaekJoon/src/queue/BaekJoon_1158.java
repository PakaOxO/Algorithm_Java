package queue;

import java.io.*;
import java.util.*;

public class BaekJoon_1158 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		for (int i=1; i<=N; i++) {
			q.add(i);
		}
		
		int[] answer = new int[N];
		int pointer = 0;
		while (q.size() > 0) {
			for (int i=0; i<K-1; i++) {
				q.add(q.poll());
			}
			answer[pointer++] = q.poll();
		}
		StringBuilder sb = new StringBuilder("<");
		for (int i=0; i<N; i++) {
			if (i < N - 1) sb.append(answer[i]).append(", ");
			else sb.append(answer[i]).append(">");
		}
		System.out.println(sb);
		br.close();
	}

}
