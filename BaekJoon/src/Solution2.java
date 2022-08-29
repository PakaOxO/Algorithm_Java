
import java.io.*;
import java.util.*;

public class Solution2 {
	static int kMin, kMax;
	static int[] scoreCnt;
	static int[] scoreAcc;
	static int answer;
	
	static void getAnswer(int T1, int T2) {
		int cntC = 0;
		int cntB = 0;
		int cntA = 0;
		for (int i=T1-1; i>0; i--) {
			if (scoreAcc[i] == 0) continue;
			cntC = scoreAcc[i];
			break;
		}
		for (int i=T2-1; i>=T1; i--) {
			if (scoreAcc[i] == 0) continue;
			cntB = scoreAcc[i] - cntC;
			break;
		}
		for (int i=100; i>=T2; i--) {
			if (scoreAcc[i] == 0) continue;
			cntA = scoreAcc[i] - cntB - cntC;
			break;
		}
		
		if (cntC < kMin || cntC > kMax || cntB < kMin || cntB > kMax || cntA < kMin || cntA > kMax) return;
		int min = Math.min(cntA, Math.min(cntB, cntC));
		int max = Math.max(cntA, Math.max(cntB, cntC));
		answer = Math.min(answer, max - min);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			kMin = Integer.parseInt(st.nextToken());
			kMax = Integer.parseInt(st.nextToken());
			
			scoreCnt = new int[101];
			scoreAcc = new int[101];
			int T1 = Integer.MAX_VALUE;
			int T2 = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				int score = Integer.parseInt(st.nextToken());
				scoreCnt[score]++;
				if (score > T2) T2 = score;
				if (score < T1) T1 = score;
			}
			
			int acc = 0;
			for (int i=1; i<101; i++) {
				acc += scoreCnt[i];
				scoreAcc[i] = acc;
			}
			
			answer = N + 1;
			for (int i=T1; i<=T2; i++) {
				for (int j=i+1; j<=T2; j++) {
					getAnswer(i, j);
				}
			}
			if (answer == N + 1) answer = -1;
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}

//5
//5 1 4
//3 5 5 4 5
//6 2 6
//5 3 3 5 5 1
//7 1 6
//3 3 5 2 5 1 2
//8 1 7
//3 1 1 2 2 5 3 5
//10 1 6
//4 4 2 4 5 2 5 3 5 5
