package level_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 파스칼의 삼각형
public class SWEA_2005 {
	public static int[][] pascalTriangle = new int[10][];
	
	public static int[] getPascalTriangle(int n) {
		int[] line = new int[n];
		for (int i=0; i<n; i++) {
			if (i == 0 || i == n-1) {
				line[i] = 1;
			} else {
				line[i] = pascalTriangle[n-2][i-1] + pascalTriangle[n-2][i];
			}
		}
		
		return line;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCnt = Integer.parseInt(br.readLine());
		for (int i=0; i<testCnt; i++) {
			int N = Integer.parseInt(br.readLine());
			for (int j=1; j<=N; j++) {
				pascalTriangle[j-1] = getPascalTriangle(j);
			}
			
			System.out.println("#" + (i + 1));
			for (int j=0; j<N; j++) {
				String line = "";
				for (int k=0; k<j+1; k++) {
					line += pascalTriangle[j][k] + " ";
				}
				System.out.println(line.trim());
			}
		}
		br.close();
	}

}
