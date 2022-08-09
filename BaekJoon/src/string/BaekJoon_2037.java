package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문자 메시지
public class BaekJoon_2037 {
	static int[] number = { 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9 };
	static int[] cnt = { 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 1, 2, 3, 1, 2, 3, 4 };
	static int prev;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		String message = br.readLine();
		prev = -1;
		int answer = 0;
		for (int i=0; i<message.length(); i++) {
			if (message.charAt(i) == ' ') {
				answer += p;
				prev = -1;
				continue;
			}
			int letter = (int)message.charAt(i) - 65;
			if (prev == number[letter]) {
				answer += w;
			}
			answer += (p * cnt[letter]);
			prev = number[letter];
		}
		System.out.println(answer);
		br.close();
	}

}
