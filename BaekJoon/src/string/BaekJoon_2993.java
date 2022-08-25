package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 세 부분
public class BaekJoon_2993 {
	static String str;
	static int N;
	static String answer;
	
	static void convert(int i, int j) {
		StringBuilder sb1 = new StringBuilder(str.substring(0, i));
		StringBuilder sb2 = new StringBuilder(str.substring(i, j));
		StringBuilder sb3 = new StringBuilder(str.substring(j, N));
		StringBuilder sb = new StringBuilder();
		sb.append(sb1.reverse()).append(sb2.reverse()).append(sb3.reverse());
		
		if (answer == null) answer = sb.toString();
		else {
			if (answer.compareTo(sb.toString()) > 0) answer = sb.toString();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		N = str.length();
		
		for (int i=1; i<N-1; i++) {
			for (int j=i+1; j<N; j++) {
				convert(i, j);
			}
		}
		System.out.println(answer);
		br.close();
	}

}
