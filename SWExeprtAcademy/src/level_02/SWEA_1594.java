package level_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 달팽이 껍질
public class SWEA_1594 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCnt = Integer.parseInt(br.readLine());
		for (int i=0; i<testCnt; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] snailShell = new int[N][N];
			
			int col = 0;
			int row = -1;
			int sw = 1;
			int len = N;
			
			int num = 1;
			while (num <= N*N) {
				for (int j=0; j<len; j++) {
					row += sw;
					snailShell[col][row] = num;
					num++;
				} len--;
				
				for (int j=0; j<len; j++) {
					col += sw;
					snailShell[col][row] = num;
					num++;
				}
				sw *= -1;
			}
			
			System.out.println("#" + (i + 1));
			for (int j=0; j<N; j++) {
				String line = "";
				for (int k=0; k<N; k++) {
					line += (snailShell[j][k] + " ");
				}
				System.out.println(line.trim());
			}
			
		}
		br.close();
	}

}
