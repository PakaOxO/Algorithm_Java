package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 장애물 경주 난이도
public class SWEA_6730 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] height = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				height[j] = Integer.parseInt(st.nextToken());
			}
			
			int upMax = 0;
			int downMax = 0;
			for (int j=0; j<N-1; j++) {
				if (height[j] < height[j+1]) {
					int upGap = height[j+1] - height[j];
					if (upGap > upMax) upMax = upGap;
				} else {
					int downGap = height[j] - height[j+1];
					if (downGap > downMax) downMax = downGap;
				}
			}
			
			System.out.printf("#%d %d %d\n", i + 1, upMax, downMax);
		}
		br.close();
	}

}
