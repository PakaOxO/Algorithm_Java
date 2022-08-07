package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 문자열의 거울상
public class SWEA_10804 {
	private static Map<Character, Character> mirroring = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		mirroring.put('b', 'd');
		mirroring.put('d', 'b');
		mirroring.put('p', 'q');
		mirroring.put('q', 'p');
		
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=T; i++) {
			sb.append("#" + i + " ");
			String input = br.readLine();
			for (int j=input.length()-1; j>=0; j--) {
				sb.append(mirroring.get(input.charAt(j)));
			}
			sb.append("\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
