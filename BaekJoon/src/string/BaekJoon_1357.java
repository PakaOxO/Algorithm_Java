package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 뒤집힌 문자열
public class BaekJoon_1357 {
	public static int rev(int x) {
		if (x < 10) return x;
		StringBuilder sb = new StringBuilder(Integer.toString(x));
		sb.reverse();
		return Integer.parseInt(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		System.out.println(rev(rev(X) + rev(Y)));
	}

}
