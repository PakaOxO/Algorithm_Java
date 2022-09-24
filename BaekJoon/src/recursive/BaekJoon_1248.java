package recursive;

import java.io.*;

/**
 * BaekJoon_1248, Guess
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 입력 받는 위치에 숫자를 넣기 전에 해당 위치 부호 체크(i = j), 음수면 음수를 양수면 양수를 0이면 0을 추가
 * 	2. 실제로 추가하기 전에 check 함수를 통해 해당 위치에 숫자를 추가했을 때 누적합 부호도 일치하는지 체크
 * 		2.1 일치하면 추가하고 다음 depth로 이동
 * 		2.2 일치하지 않으면 다른 숫자 찾음
 * 	3. N 길이 만큼의 숫자를 모두 찾았으면 출력
 *
 */
public class BaekJoon_1248 {
	static int N;
	static char[][] acc;
	static int[] sel;
	
	static boolean check(int depth) {
		for (int i=0; i<depth; i++) {
			int sum = 0;
			for (int j=i; j<depth; j++) {
				sum += sel[j];
				if (sum < 0 && acc[i][j] != '-') return false;
				else if (sum > 0 && acc[i][j] != '+') return false;
				else if (sum == 0 && acc[i][j] != '0') return false;
			}
		}
		return true;
	}
	
	
	static void dfs(int sum, int depth) {
		if (depth == N) {
			if (!check(depth)) return;
			StringBuilder sb = new StringBuilder();
			for (int i=0; i<sel.length; i++) {
				if (i < sel.length - 1) sb.append(sel[i]).append(" ");
				else sb.append(sel[i]);
			}
			System.out.println(sb);
			System.exit(0);
			return;
		}
		
		char c = acc[depth][depth];
		for (int i=0; i<=10; i++) {
			if (c == '-') {
				if (i == 0) continue;
				sel[depth] = -i;
				if (!check(depth + 1)) continue;
				dfs(sum - i, depth + 1);
			}
			else if (c == '+')  {
				if (i == 0) continue;
				sel[depth] = i;
				if (!check(depth + 1)) continue;
				dfs(sum + i, depth + 1);
			} else {
				sel[depth] = 0;
				dfs(sum, depth + 1);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		acc = new char[N][N];
		
		String input = br.readLine();
		int idx = 0;
		for (int i=0; i<N; i++) {
			for (int j=i; j<N; j++) {
				acc[i][j] = input.charAt(idx++);
			}
		}
		
		sel = new int[N];
		dfs(0, 0);
	}

}
