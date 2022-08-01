package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 회문 2
public class SWEA_1216 {
	public static int N = 100;
	public static int maxL;
	public static char[][] board;
	
	public static boolean checkCol(int len) {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N-len+1; j++) {
				boolean isPalindrome = true;
				for (int k=0; k<len; k++) {
					if (j+k == j+len-k-1) continue;
					if (board[i][j+k] != board[i][j+len-k-1]) {
						isPalindrome = false;
						break;
					}
				}
				if (isPalindrome) {
					maxL = len;
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean checkRow(int len) {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N-len+1; j++) {
				boolean isPalindrome = true;
				for (int k=0; k<len; k++) {
					if (j+k == j+len-k-1) continue;
					if (board[j+k][i] != board[j+len-k-1][i]) {
						isPalindrome = false;
						break;
					}
				}
				if (isPalindrome) {
					maxL = len;
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		for (int i=1; i<=T; i++) {
			int no = Integer.parseInt(br.readLine());
			board = new char[N][N];
			for (int j=0; j<N; j++) {
				board[j] = br.readLine().toCharArray();
			}
			
			maxL = 0;
			for (int l=2; l<=N; l++) {
				if (checkCol(l)) continue;
				checkRow(l);
			}
			sb.append("#" + no + " " + maxL + "\n");
		}
		System.out.println(sb.toString().trim());
	}

}
