package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 단어 뒤집기
public class BaekJoon_9093 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++) {
			String[] line = br.readLine().split(" ");
			StringBuilder sb = new StringBuilder();
			for (int j=0; j<line.length; j++) {
				StringBuilder word = new StringBuilder(line[j]);
				sb.append(word.reverse() + " ");
			}
			System.out.println(sb.toString().trim());
		}
	}

}
