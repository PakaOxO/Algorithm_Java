package level_02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// ÆÄ½ºÄ®ÀÇ »ï°¢Çü
public class SWEA_2005_2 {
	static int[][] pascalTriangle;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append("\n");
			int N = Integer.parseInt(br.readLine());
			pascalTriangle = new int[N][];
			for (int i=0; i<N; i++) {			
				int[] line = new int[i+1];
				line[0] = 1;
				if (i > 0) line[i] = 1;
				pascalTriangle[i] = line;
				if (i > 1) {
					for (int j=1; j<=i-1; j++) {
						pascalTriangle[i][j] = pascalTriangle[i-1][j-1] + pascalTriangle[i-1][j];
					}
				}
			}
			for (int i=0; i<N; i++) {
				for (int j=0; j<i+1; j++) {
					sb.append(pascalTriangle[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
		br.close();
	}

}
