package queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 요세푸스 문제 0
public class BaekJoon_11866 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		Queue<Integer> q = new LinkedList<>();
		for (int i=1; i<=N; i++) {
			q.add(i);
		}
		while (true) {
			if (q.size() == 1) {
				sb.append(q.poll() + ">");
				break;
			}
			for (int j=0; j<K-1; j++) {
				q.add(q.poll());
			}
			sb.append(q.poll() + ", ");
		}
		System.out.println(sb);
		br.close();
	}

}
