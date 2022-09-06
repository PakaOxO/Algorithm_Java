package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BaekJoon_9093, 단어 뒤집기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 입력받은 문자열을 뒤집어 출력
 * 	2. StringBuilder Class의 reverse() 메서드를 사용해 문자열을 뒤집고,
 *  3. 출력 문자열에 추가
 */
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
