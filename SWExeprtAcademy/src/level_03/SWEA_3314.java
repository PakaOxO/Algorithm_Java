package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3314 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb.append("#" + i + " ");
			int sum = 0;
			for (int j=0; j<5; j++) {
				int score = Integer.parseInt(st.nextToken());
				sum += (score < 40) ? 40 : score;
			}
			sb.append((sum / 5) + "\n");
		}
		System.out.println(sb.toString().trim());
	}

}
