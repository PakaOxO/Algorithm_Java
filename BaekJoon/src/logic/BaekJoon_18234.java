package logic;

import java.io.*;
import java.util.*;

public class BaekJoon_18234 {
	static PriorityQueue<int[]> carrot;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		carrot = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o2[0] - o1[0];
				}
				return o2[1] - o1[1];
			}
		});
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			carrot.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}
		br.close();
		
		long answer = 0;
		for (int i=0; i<N; i++) {
			int[] c = carrot.poll();
			answer += c[0] + ((long)c[1] * (T - (i + 1)));
		}
		System.out.println(answer);
	}

}
