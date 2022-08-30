package recursive;

import java.io.*;
import java.util.*;

// Z
public class BaekJoon_1074 {
	static int answer;
	
	static void getNumber(int n, int r, int c) {
		int square = (int)Math.pow(2, n - 1);
		int acc = (int)Math.pow(4, n - 1);
		if (square > r && square > c) {
			getNumber(n - 1, r, c);
			return;
		}
		
		if (r < 2 && c < 2) {
			if (r == 1) answer += 2;
			if (c == 1) answer += 1;
			return;
		}
		if (r >= square && c >= square) {
			answer += acc * 3;
			getNumber(n - 1, r - square, c - square);
		} else if (r >= square) {
			answer += acc * 2;
			getNumber(n - 1, r - square, c);
			return;
		} else if (c >= square) {
			answer += acc;
			getNumber(n - 1, r, c - square);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		answer = 0;
		getNumber(N, r, c);
		
		System.out.println(answer);
		br.close();
	}

}
