package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 요세푸스 문제
public class BaekJoon_1158 {
	static List<Integer> q;
	static int[] answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		q = new ArrayList<>();
		for (int i=1; i<=N; i++) q.add(i);
		answer = new int[N];
		
		int idx = 0;
		int nCnt = 0;
		while (q.size() > 0) {
			idx = (idx + (K - 1) >= q.size()) ? (idx + (K - 1)) % q.size() : idx + (K - 1);
			answer[nCnt++] = q.remove(idx);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for (int i=0; i<N; i++) {
			if (i < N - 1) sb.append(answer[i] + ", ");
			else sb.append(answer[i]);
		}
		sb.append(">");
		System.out.println(sb);
		br.close();
	}

}
