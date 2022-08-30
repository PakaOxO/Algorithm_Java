package dp;

import java.io.*;
import java.util.*;

// 파스칼의 삼각형
public class BaekJoon_16395 {
	static int[][] pascalTriangle;
	static void getPascalTriangle(int N) {
		pascalTriangle = new int[N][];
		for (int i=0; i<N; i++) {
			pascalTriangle[i] = new int[i + 1];
			pascalTriangle[i][0] = 1;
			pascalTriangle[i][i] = 1;
		}
		
		for (int i=2; i<N; i++) {
			for (int j=1; j<i; j++) {
				pascalTriangle[i][j] = pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j];
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		getPascalTriangle(N);
		System.out.println(pascalTriangle[N-1][K-1]);
		br.close();
	}

}
