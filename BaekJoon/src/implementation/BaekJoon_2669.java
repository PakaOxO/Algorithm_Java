package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 직사각형 네 개의 합집합
public class BaekJoon_2669 {
	static StringTokenizer st;
	static boolean[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new boolean[100][100];
		int answer = 0;
		for (int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			int fromX = Integer.parseInt(st.nextToken());
			int fromY = Integer.parseInt(st.nextToken());
			int toX = Integer.parseInt(st.nextToken());
			int toY = Integer.parseInt(st.nextToken());
			for (int j=fromY; j<toY; j++) {
				for (int k=fromX; k<toX; k++) {
					if (!board[j][k]) {
						board[j][k] = true;
						answer++;
					}
				}
			}
		}
		System.out.println(answer);
		br.close();
	}

}
