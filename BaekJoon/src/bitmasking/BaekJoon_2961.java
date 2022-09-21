package bitmasking;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2961, 도영이가 만든 맛있는 음식
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 
 *
 */
public class BaekJoon_2961 {
	static int N;
	static int[][] flavor;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		flavor = new int[N][2];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			flavor[i][0] = Integer.parseInt(st.nextToken());
			flavor[i][1] = Integer.parseInt(st.nextToken());
		}
		br.close();
		min = Integer.MAX_VALUE;
		for (int i=1; i<(1<<N); i++) {
			int s = 1;
			int b = 0;
			for (int j=0; j<N; j++) {
				if ((i & (1 << j)) == 0) continue;
				s *= flavor[j][0];
				b += flavor[j][1];
			}
			min = Math.min(min, Math.abs(s - b));
		}
		System.out.println(min);
	}

}
