package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_13549, 숨바꼭질 3
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 
 *
 */
public class BaekJoon_13549 {
	static int N, K;
	static int[] time;
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
		
		while (q.size() > 0) {
			int curr = q.poll();
			
			if (curr > 0 && curr * 2 <= 100000 && curr * 2 != N) {
				 if (time[K] == 0 || time[K] > 0 && time[curr] < time[K]) {
					if (curr * 2 != K) q.offer(curr * 2);
					time[curr * 2] = Math.min(time[curr * 2], time[curr]);
				}
			}
			
			if (curr - 1 >= 0 && curr - 1 != N) {
				if (time[K] == 0 || (time[K] > 0 && time[curr] + 1 < time[K])) {
					if (curr - 1 != K) q.offer(curr - 1);
					time[curr - 1] = (time[curr - 1] == 0) ? time[curr] + 1 : Math.min(time[curr - 1], time[curr] + 1);
				}
			}
			
			if (curr + 1 <= 100000 && curr + 1 != N) {
				if (time[K] == 0 || (time[K] > 0 && time[curr] + 1 < time[K])) {
					if (curr + 1 != K) q.offer(curr + 1);
					time[curr + 1] = (time[curr + 1] == 0) ? time[curr] + 1 : Math.min(time[curr + 1], time[curr] + 1);
				}
			}
			
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		time = new int[100001];
		bfs();
		System.out.println(Arrays.toString(time));
		
		System.out.println(time[K]);
	}

}
