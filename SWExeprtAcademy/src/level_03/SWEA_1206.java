package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// View
public class SWEA_1206 {
	static StringTokenizer st;
	static int[] heights;
	
	static int cntView(int idx) {
		int max = Integer.MIN_VALUE;
		for (int i=idx-2; i<=idx+2; i++) {
			if (i == idx) continue;
			if (heights[i] >= heights[idx]) return 0;
			else {
				max = Math.max(heights[i], max);
			}
		}
		return heights[idx] - max;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		for (int i=1; i<=T; i++) {
			int result = 0;
			int N = Integer.parseInt(br.readLine());
			heights = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				heights[j] = Integer.parseInt(st.nextToken());
			}
			
			for (int j=2; j<N-2; j++) {
				result += cntView(j);
			}
			sb.append("#" + i + " " + result + "\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
