package recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 하노이 탑 이동 순서
public class BaekJoon_11729 {
	static StringBuilder process;
	static int cnt;
	
	static void move(int from, int to) {
		cnt++;
		process.append(from).append(" ").append(to).append("\n");
	}
	
	static void hanoi(int N, int from, int via, int to) {
		if (N == 1) {
			move(from, to);
			return;
		}
		hanoi(N - 1, from, to, via);
		move(from, to);
		hanoi(N - 1, via, from, to);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		process = new StringBuilder();
		cnt = 0;
		hanoi(N, 1, 2, 3);
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append("\n").append(process);
		System.out.print(sb);
		br.close();
	}

}
