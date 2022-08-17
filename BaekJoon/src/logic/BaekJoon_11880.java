package logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 개미
public class BaekJoon_11880 {
	static StringBuilder sb = new StringBuilder();
	
	static void getQuareSum(long t1, long t2, long t3) {
		long result = 0;
		if (t1 >= t2 && t1 >= t3) {
			result += ((t2 + t3) * (t2 + t3)) + (t1 * t1);
		} else if (t2 >= t1 && t2 >= t3) {
			result += ((t1 + t3) * (t1 + t3)) + (t2 * t2);
		} else {
			result += ((t1 + t2) * (t1 + t2)) + (t3 * t3);
		}
		
		sb.append(result).append("\n");
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long a = Integer.parseInt(st.nextToken());
			long b = Integer.parseInt(st.nextToken());
			long c = Integer.parseInt(st.nextToken());
			getQuareSum(a, b, c);
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
