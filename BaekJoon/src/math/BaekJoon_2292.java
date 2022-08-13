package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 벌집 
public class BaekJoon_2292 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int acc = 1;
		int line = 1;
		while (acc < N) {
			acc += line * 6;
			line++;
		}
		System.out.println(line);
	}

}
