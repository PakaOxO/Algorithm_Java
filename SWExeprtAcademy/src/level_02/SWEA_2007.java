package level_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 패턴 마디의 길이
public class SWEA_2007 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		for (int i=0; i<N; i++) {
			String input = br.readLine().trim();
			int len = 1;
			
			while (len <= 10) {
				String word = input.substring(0, len);
				String next = input.substring(len, len+len);
				
				if (word.equals(next)) break;
				len++;
			}
			System.out.printf("#%d %d\n", i + 1, len);
		}
	}

}
