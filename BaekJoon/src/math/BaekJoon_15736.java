package math;

import java.io.*;

// 청기 백기 
public class BaekJoon_15736 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		for (int i=1; i*i<=N; i++) {
			answer++;
		}
		System.out.println(answer);
		br.close();
	}

}
