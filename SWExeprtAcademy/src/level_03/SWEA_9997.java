package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 미니멀리즘 시계
public class SWEA_9997 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=T; i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append("#" + i + " " + (N / 30 % 12) + " " + ((N % 30) * 60 / 30) + "\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}
}
