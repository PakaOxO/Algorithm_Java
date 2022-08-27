package heap;

import java.io.*;
import java.util.*;

// 문제 추천 시스템 Version 1 
public class BaekJoon_21939 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> {
			if (o1[1] == o2[1]) {
				return o2[0] - o1[0];
			}
			return o2[1] - o1[1];
		});
		
		PriorityQueue<Integer> deleteMax = new PriorityQueue<>((o1, o2) -> o2 - o1);
		
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> {
			if (o1[1] == o2[1]) {
				return o1[0] - o2[0];
			}
			return o1[1] - o2[1];
		});
		
		PriorityQueue<Integer> deleteMin = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] q = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			maxHeap.add(q);
			minHeap.add(q);
		}
		
		int M = Integer.parseInt(br.readLine());
		for (int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			if (order.equals("add")) {
				int[] q = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
				maxHeap.add(q);
				minHeap.add(q);
				continue;
			}
			if (order.equals("recommend")) {
				int type = Integer.parseInt(st.nextToken());
				if (type == 1) {
					if (deleteMax.size() > 0 && maxHeap.peek()[0] == deleteMax.peek()) {
						maxHeap.poll();
						deleteMax.poll();
					}
					sb.append(maxHeap.peek()[0]).append("\n");
				}
				else {
					if (deleteMin.size() > 0 && minHeap.peek()[0] == deleteMin.peek()) {
						minHeap.poll();
						deleteMin.poll();
					}
					sb.append(minHeap.peek()[0]).append("\n");
				}
				continue;
			}
			if (order.equals("solved")) {
				int qNum = Integer.parseInt(st.nextToken());
				deleteMax.add(qNum);
				deleteMin.add(qNum);
				continue;
			}
		}
		System.out.print(sb);
		br.close();
	}

}
