package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 회문 2
public class SWEA_1216_bak {
	public static int N = 100;
	
	public static boolean isPalindrome(StringBuilder sb) {
		String line = sb.toString();
		String reversed = sb.reverse().toString();
		if (line.equals(reversed)) return true;
		return false;
	}
	public static int maxLenPalindrome(String[][] board) {
		int max = Integer.MIN_VALUE;
		String maxLine = "";
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (N - j < max) break;
				StringBuilder strHorz = new StringBuilder();
				StringBuilder strVert = new StringBuilder();
				for (int k=j; k<N; k++) {
					strHorz.append(board[i][k]);
					if (isPalindrome(strHorz)) {
						int len = strHorz.length();
						if (len > max) {
							max = len;
							maxLine = strHorz.toString();
						}
					}
					strVert.append(board[k][i]);
					if (isPalindrome(strVert)) {
						int len = strVert.length();
						if (len > max) {
							System.out.println(strVert + " " + k + " " + i);
							max = len;
							maxLine = strVert.toString();
						}
					}
				}
			}
		}
		System.out.println(maxLine);
		return max;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 1;
		for (int i=1; i<=T; i++) {
			int no = Integer.parseInt(br.readLine());
			String[][] board = new String[N][];
			for (int j=0; j<N; j++) {
				board[j] = br.readLine().split("");
			}
			System.out.println("#" + no + " " + maxLenPalindrome(board));
		}
	}

}
