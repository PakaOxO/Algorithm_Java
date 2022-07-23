package level_02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최빈수 구하기
public class SWEA_1204 {
	public static int[] scoreCnt = new int[101];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCnt = Integer.parseInt(br.readLine());
		for (int i=0; i<testCnt; i++) {
			int testNo = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			scoreCnt = new int[101];
			for (int j=0; j<1000; j++) {
				int score = Integer.parseInt(st.nextToken());
				scoreCnt[score]++;
			}
			
			int idx = 0;
			int max = Integer.MIN_VALUE;
			for (int j=0; j<101; j++) {
				if (scoreCnt[j] >= max) {
					max = scoreCnt[j];
					idx = j;
				}
			}
			System.out.printf("#%d %d\n", testNo, idx);
		}
		br.close();
	}

}
