package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DNA
public class BaekJoon_1969 {
	static int N, M;
	static char[] data = { 'A', 'C', 'G', 'T' };
	static int[][] cnt;


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = new int[M][4];
		for (int i=0; i<N; i++) {
			String dna = br.readLine();
			for (int j=0; j<M; j++) {
				char c = dna.charAt(j);
				if (c == 'A') cnt[j][0]++;
				else if (c == 'C') cnt[j][1]++;
				else if (c == 'G') cnt[j][2]++;
				else if (c == 'T') cnt[j][3]++;
			}
		}
		StringBuilder answer = new StringBuilder();
		int dist = 0;
		for (int i=0; i<M; i++) {
			int maxIdx = 0;
			for (int j=1; j<4; j++) {
				if (cnt[i][j] > cnt[i][maxIdx]) maxIdx = j;
			}
			answer.append(data[maxIdx]);
			dist += (N - cnt[i][maxIdx]);
		}
		answer.append("\n").append(dist);
		System.out.println(answer);
		br.close();
	}

}

