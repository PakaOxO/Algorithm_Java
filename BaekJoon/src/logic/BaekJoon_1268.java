package logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 임시 반장 정하기
public class BaekJoon_1268 {
	private static boolean[][] isClassMate;
	private static int[] cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		isClassMate = new boolean[N][N];
		cnt = new int[N];
		int[][] arr = new int[N][5];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i=0; i<N; i++) {
			for (int j=i+1; j<N; j++) {
				for (int k=0; k<5; k++) {
					if (arr[i][k] == arr[j][k] && !isClassMate[i][j]) {
						isClassMate[i][j] = true;
						isClassMate[j][i] = true;
						cnt[i]++;
						cnt[j]++;
					}
				}
			}
		}
		int max = 0;
		int idx = 0;
		for (int i=0; i<N; i++) {
			if (cnt[i] > max) {
				max = cnt[i];
				idx = i;
			}
		}
		System.out.println(idx + 1);
		br.close();
	}

}
