package recursive;

import java.io.*;
import java.util.*;

// 투자의 귀재 배주형 (재풀이)
public class BaekJoon_19947_2 {
	static int answer;
	
	static void dfs(int h, int y) {
		if (y == 0) {
			answer = (int)Math.max(answer, h);
			return;
		}
		if (y >= 5) {
			dfs((int)(h * 1.35), y - 5);
		}
		if (y >= 3) {
			dfs((int)(h * 1.2), y - 3);
		}
		dfs((int)(h * 1.05), y - 1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		answer = 0;
		dfs(H, Y);
		System.out.println(answer);
		br.close();
	}

}
