package dp;

import java.io.*;

/**
 * BaekJoon_9655, 돌 게임
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 돌 게임에서 항상 자신이 승리하는 방향으로 선택을 할 것이므로 선공권이 정해진 상태에서 돌 개수에 대한 승자는 자동으로 정해진다.
 * 	2. 돌의 개수가 1, 3일 땐 선공권이 있는 상근이가, 돌의 개수가 2일 땐 선공권을 가진 상근이가 1을 선택하고 창영이가 다음 1개를 선택
 * 	3. 그 이후에는 돌이 4개일 때를 예시로 선공인 상근이가 1, 3개를 선택하면 남은 돌은 3, 1개이고 창영이는 항상 자신에 유리한 선택을 하므로 창영이가 이기게 된다.
 * 		3.1 4개 이후에는 돌을 1개, 3개 빼가며 N - 1, N - 3개에서 승자가 아닌 사람이 승리하게 되는 구조.
 *
 */
public class BaekJoon_9655 {
	static String[] memo;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		memo = new String[1001];
		memo[1] = "SK";
		memo[2] = "CY";
		memo[3] = "SK";
		if (N > 3) {
			for (int i=4; i<=N; i++) {
				if(memo[i - 1].equals("CY")) memo[i] = "SK";
				else memo[i] = "CY";
			}
		}
		System.out.println(memo[N]);
		br.close();
	}

}