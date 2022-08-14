package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 비밀 이메일  
public class BaekJoon_2999 {
	static char[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		int row = 0, col = 0;
		for (int i=1; i<=Math.sqrt(len); i++) {
			if (len % i == 0) {
				row = i;
				col = len / i;
			}
		}
		arr = new char[row][col];
		int idx = 0;
		for (int i=0; i<col; i++) {
			for (int j=0; j<row; j++) {
				arr[j][i] = str.charAt(idx++);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				sb.append(arr[i][j]);
			}
		}
		System.out.println(sb);
		br.close();
	}

}
