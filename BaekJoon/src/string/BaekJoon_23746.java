package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 문자열 압축 해제
public class BaekJoon_23746 {
	static Map<Character, String> map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String value = st.nextToken();
			char key = st.nextToken().charAt(0);
			map.put(key, value);
		}
		String input = br.readLine();
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<input.length(); i++) {
			sb.append(map.get(input.charAt(i)));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		System.out.println(sb.toString().substring(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())));
		br.close();
	}

}
