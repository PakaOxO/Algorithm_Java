package recursive;

import java.io.*;

/**
 * BaekJoon_9095, 1, 2, 3 더하기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 1,2,3의 숫자를 사용해 입력 받은 숫자를 만드는 순열을 찾는 문제
 * 	2. 입력받은 숫자에서 1,2,3 중 하나를 선택해 빼가며 재귀 호출, 뺀 값이 0이되면 cnt + 1
 *
 */
public class BaekJoon_9095 {
	static int cnt;
	
	static void dfs(int num) {
		if (num == 0) {
			cnt++;
		}
		
		for (int i=1; i<4; i++) {
			if (i > num) break;
			dfs(num - i);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			cnt = 0;
			dfs(Integer.parseInt(br.readLine()));
			sb.append(cnt).append("\n");
		}
		br.close();
		
		System.out.print(sb);
	}

}
