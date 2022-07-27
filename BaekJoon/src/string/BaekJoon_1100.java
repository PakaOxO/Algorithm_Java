package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 하얀 칸
public class BaekJoon_1100 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		for (int i=0; i<8; i++) {
			String line = br.readLine();
			for (int j=(i%2); j<8; j+=2) {
				if (line.charAt(j) == 'F') answer++;
			}
		}
		System.out.println(answer);
	}

}
