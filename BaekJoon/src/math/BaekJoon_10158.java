package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 개미
public class BaekJoon_10158 {
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		long t = Integer.parseInt(br.readLine());
		
		long sR = (t + r) / row;
		long rR = (t + r) % row;
		long sC = (t + c) / col;
		long rC = (t + c) % col;
		
		long aR = ( sR % 2 == 0 ) ? rR : row - rR;
		long aC = ( sC % 2 == 0 ) ? rC : col - rC;
		
		StringBuilder sb = new StringBuilder();
		sb.append(aR);
		sb.append(" ");
		sb.append(aC);
		System.out.println(sb);
		br.close();
	}

}
