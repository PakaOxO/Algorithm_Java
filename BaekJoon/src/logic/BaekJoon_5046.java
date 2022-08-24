package logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 전국 대학생 프로그래밍 대회 동아리 연합
public class BaekJoon_5046 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int min = Integer.MAX_VALUE;
		for (int i=0; i<H; i++) {
			int P = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<W; j++) {
				int A = Integer.parseInt(st.nextToken());
				if (A < N) continue;
				min = Math.min(min, P * N);
			}
		}
		if (min > B) System.out.println("stay home");
		else System.out.println(min);
		br.close();
	}

}
