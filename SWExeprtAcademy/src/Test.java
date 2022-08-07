import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 회문 2 다시 풀기
public class Test {
	private static char[][] board;
	private static int maxLen;
	
	private static boolean checkCol(int len) {
		for (int i=0; i<100; i++) {
			for (int j=0; j<100-len+1; j++) {
				boolean isPalindrome = true;
				for (int k=0; k<len; k++) {
					if (j+k == j+len-k-1) break;
					if (board[i][j+k] != board[i][j+len-k-1]) {
						isPalindrome = false;
						break;
					}
				}
				if (isPalindrome) {
					maxLen = len;
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean checkRow(int len) {
		for (int i=0; i<100; i++) {
			for (int j=0; j<100-len+1; j++) {
				boolean isPalindrome = true;
				for (int k=0; k<len; k++) {
					if (j+k == j+len-k-1) break;
					if (board[j+k][i] != board[j+len-k-1][i]) {
						isPalindrome = false;
						break;
					}
				}
				if (isPalindrome) {
					maxLen = len;
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=10; i++) {
			int tNo = Integer.parseInt(br.readLine());
			board = new char[100][100];
			maxLen = 100;
			for (int j=0; j<100; j++) {
				board[j] = br.readLine().toCharArray();
			}
			
			for (int len=2; len<=100; len++) {
				if (checkCol(len)) continue;
				checkRow(len);
			}
			System.out.println(maxLen);
		}
		
		// System.out.println(sb.toString().trim());
		br.close();
	}

}
