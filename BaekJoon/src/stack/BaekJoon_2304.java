package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 창고 다각형
public class BaekJoon_2304 {
	static int[][] heights;
	static int maxPos;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		heights = new int[N][2];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			heights[i][0] = Integer.parseInt(st.nextToken());
			heights[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(heights, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		int maxHeight = 0;
		int maxPos = 0;
		for (int i=0; i<N; i++) {
			if (heights[i][1] > maxHeight) {
				maxHeight = heights[i][1];
				maxPos = i;
			}
		}
		
		int answer = maxHeight;
		int prevPos = 0;
		maxHeight = heights[0][1];
		for (int i=0; i<=maxPos; i++) {
			if (heights[i][1] >= maxHeight) {
				answer += (maxHeight * (heights[i][0] - heights[prevPos][0]));
				maxHeight = heights[i][1];
				prevPos = i;
			}
		}
		
		prevPos = N - 1;
		maxHeight = heights[N - 1][1];
		for (int i=N-1; i>=maxPos; i--) {
			if (heights[i][1] >= maxHeight) {
				answer += (maxHeight * (heights[prevPos][0] - heights[i][0]));
				maxHeight = heights[i][1];
				prevPos = i;
			}
		}
		System.out.println(answer);
		br.close();
	}

}
