package queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// Router
public class BaekJoon_15828 {
	static Queue<Integer> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int bufferSize = Integer.parseInt(br.readLine());
		q = new LinkedList<>();
		int data;
		while ( (data = Integer.parseInt(br.readLine())) != -1) {
			if (data == 0) {
				q.poll();
				continue;
			}
			if (q.size() == bufferSize) {
				continue;
			}
			
			q.add(data);
		}
		StringBuilder sb = new StringBuilder();
		if (q.size() == 0) sb.append("empty");
		while (q.size() > 0) {
			sb.append(q.poll());
			if (q.size() > 0) sb.append(" ");
		}
		System.out.println(sb);
		br.close();
	}

}
