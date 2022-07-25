package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 제곱 팰린드롬 수
public class SWEA_10570 {
	public static StringBuilder result = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			int N = (int)Math.sqrt(A);
			while (N*N <= B) {
				if (N*N < A) {
					N++;
					continue;
				}
				StringBuilder sbJ = new StringBuilder(String.valueOf(N*N));
				StringBuilder sbRoot = new StringBuilder(String.valueOf(N));
				
				if (sbJ.toString().equals(sbJ.reverse().toString()) && sbRoot.toString().equals(sbRoot.reverse().toString())) cnt++;
				N++;
			}
			result.append("#" + i + " " + cnt + "\n");
		}
		System.out.println(result);
		br.close();
	}

}
