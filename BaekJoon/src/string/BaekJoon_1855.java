package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 암호
public class BaekJoon_1855 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int N = input.length() / K;
		char[][] board = new char[N][K];
		
		int idx = 0;
		for (int i=0; i<N; i++) {
			if (i % 2 == 0) {
				for (int j=0; j<K; j++) {
					board[i][j] = input.charAt(idx++);
				}
			} else {
				for (int j=K-1; j>=0; j--) {
					board[i][j] = input.charAt(idx++);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<K; i++) {
			for (int j=0; j<N; j++) {
				sb.append(board[j][i]);
			}
		}
		System.out.println(sb);
		br.close();
	}

}
