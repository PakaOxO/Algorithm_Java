package level_01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 초심자의 회문검사 
public class SWEA_1989 {
	public static int palindrome(String str) {
		StringBuffer strLower = new StringBuffer(str.toLowerCase());
		String reversed = strLower.reverse().toString();
		
		if (str.equals(reversed)) {
			return 1;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i=0; i<N; i++) {
			String testWord = br.readLine();
			System.out.println("#" + (i + 1) + " " + palindrome(testWord));
			
		}
	}
}