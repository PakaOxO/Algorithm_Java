package level_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 조교의 성적매기기
public class SWEA_1983 {
	public static String[] scores = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCnt = Integer.parseInt(br.readLine());
		for (int i=0; i<testCnt; i++) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int K = Integer.parseInt(input[1]);
			
			double[] totals = new double[N];
			for (int j=0; j<N; j++) {
				String[] studentScore = br.readLine().split(" ");
				double total = (Integer.parseInt(studentScore[0]) * 0.35) + (Integer.parseInt(studentScore[1]) * 0.45) + (Integer.parseInt(studentScore[2]) * 0.20);
				totals[j] = total;
			}
			
			int rank = 1;
			for (int j=0; j<N; j++) {
				if (j != (K-1) && totals[j] > totals[K-1]) rank++;
			}
			System.out.printf("#%d %s\n", i + 1, scores[(rank - 1) * 10 / N]);
		}
		br.close();
	}

}
