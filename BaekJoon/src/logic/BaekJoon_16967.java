package logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 배열 복원하기 
public class BaekJoon_16967 {
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		arr = new int[H + X][W + Y];
		
		for (int i=0; i<H+X; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<W+Y; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=X; i<H; i++) {
			for (int j=Y; j<W; j++) {
				arr[i][j] = arr[i][j] - arr[i - X][j - Y];
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<H; i++) {
			for (int j=0; j<W; j++) {
				sb.append(arr[i][j]);
				if (j < W - 1) sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
