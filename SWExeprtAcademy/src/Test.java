import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 회문 2 다시 풀기
public class Test {
	static int N = 100;
	static char[][] board;
	static int max;
	
	static boolean checkCol(int len) {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N+1-len; j++) {
				boolean isPalindrome = true;
				for (int k=0; k<len; k++) {
					if (j+k >= (j+len-1-k)) break;
					if (board[i][j+k] != board[i][j+len-1-k]) {
						isPalindrome = false;
						break;
					}
				}
				if (isPalindrome) {
					max = len;
					return true;
				}
			}
		}
		
		return false;
	}
	
	static boolean checkRow(int len) {
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N+1-len; j++) {
				boolean isPalindrome = true;
				for (int k=0; k<len; k++) {
					if (j+k >= (j+len-1-k)) break;
					if (board[j+k][i] != board[j+len-1-k][i]) {
						isPalindrome = false;
						break;
					}
				}
				if (isPalindrome) {
					max = len;
					return true;
				}
			}
		}
		
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int i=0; i<T; i++) {
			int testNo = Integer.parseInt(br.readLine());
			board = new char[100][100];
			for (int j=0; j<N; j++) {
				String line = br.readLine();
				for (int k=0; k<N; k++) {
					board[j][k] = line.charAt(k);
				}
			}
			max = 100;
			for (int len=100; len>=2; len--) {
				if (checkCol(len) || checkRow(len)) break;
			}
			System.out.println("#" + testNo + " " + max);
		}
		br.close();
	}

}
