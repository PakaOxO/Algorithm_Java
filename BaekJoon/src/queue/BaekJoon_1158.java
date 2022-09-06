package queue;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1158, 조세퍼스 문제
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 입력받은 K만큼 pointer를 이동시켜가며 K번째 이동했을 때의 사람을 출력하는 문제
 * 	2. 큐를 사용해 K-1번째까지는 앞의 사람을 poll 해서 맨 뒤로 다시 add
 * 	3. K번째 사람은 poll하여 출력값이 저장
 *
 */
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
