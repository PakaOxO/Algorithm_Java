package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 그림 비교
public class BaekJoon_2160 {
	static int cCnt = 5, rCnt = 7;
	static int[][] cntDiff;
	static char[][] input;
	static int min;
	static int[] answer = new int[2];
	
	static void checkDiff(int a, int b) {
		for (int i=0; i<cCnt; i++) {
			for (int j=0; j<rCnt; j++) {
				if (input[i+(a*cCnt)][j] != input[i+(b*cCnt)][j]) {
					cntDiff[a][b]++;
					cntDiff[b][a]++;
				}
			}
		}
		if (cntDiff[a][b] < min) {
			min = cntDiff[a][b];
			answer[0] = a + 1;
			answer[1] = b + 1;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		cntDiff = new int[N][N];
		input = new char[N*cCnt][];
		for (int i=0; i<N*cCnt; i++) {
			input[i] = br.readLine().toCharArray();
		}
		min = Integer.MAX_VALUE;
		for (int i=0; i<N; i++) {
			for (int j=i+1; j<N; j++) {
				checkDiff(i, j);
			}
		}
		System.out.println(answer[0] + " " + answer[1]);
	}

}
