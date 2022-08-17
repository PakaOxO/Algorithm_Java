package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 영수증
public class BaekJoon_25304 {
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int total = 0;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			total += (Integer.parseInt(st.nextToken()) * (Integer.parseInt(st.nextToken())));
		}
		if (total == X) System.out.println("Yes");
		else System.out.println("No");
		br.close();
	}

}
