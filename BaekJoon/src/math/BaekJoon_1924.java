package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2007³â
public class BaekJoon_1924 {
	static int[] date = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static String[] day = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int diff = D - 1;
		for (int i=0; i<M-1; i++) {
			diff += date[i];
		}
		System.out.println(day[diff % 7]);
		br.close();
	}

}
