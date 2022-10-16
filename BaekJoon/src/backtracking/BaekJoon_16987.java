package backtracking;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_16987, 계란으로 계란치기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	FB. 문제에서 주어진 프로세스 그대로 진행하면 되는 문제였다... 문제를 풀때 문제에서 주어진 요소 이외에 개인적인 해석을 하지 않도록 하는 것이 좋을 것 같다.
 * 	1. 프로세스는 다음과 같다.
 * 		1.1 가장 왼쪽의 계란을 든다.
 * 		1.2 깨지지 않은 다른 계란 중에서 하나를 친다(현재 위치 기준 좌우 상관X).
 * 			1.2.1 이때 손에 든 계란이 깨져있거나 들지 않은 남은 계란들이 모두 깨져있다면 치지 않고 넘어간다.
 * 			1.2.2 계란을 쳤을 때 내구도는 상대 계란의 질량만큼 감소하며 내구도가 0 이하가 되었을 때 계란은 깨진다.
 * 		1.3 방금 들었던 계란을 원 위치에 두고 바로 오른쪽 계란을 들어 1.2로 되돌아간다.
 * 			1.3.1 만약 방금 들었던 계란이 가장 우측 계란이었다면 프로세스를 종료한다.
 *
 *	2. dfs 탐색 시에 고려할 요소 현재 들고 있는 계란의 위치이다. 풀이에서는 dfs 메서드가 현재 위치를 left 변수를 사용해 매개변수로 가지고 있다.
 *	3. dfs를 들어온 순간 계란을 들고 있는 것으로 고려한다. dfs에서는 반복문을 돌면서 현재 들고 있는 계란으로 칠 계란을 탐색한다.
 *		3.1 칠 계란이 들고 있는 계란과 같은 계란이거나, 이미 깨져있다면 다음 반복문으로 넘어간다.
 *
 */
public class BaekJoon_16987 {
	static int N;
	static int[][] eggs;
	static int max;
	
	static void dfs(int left) {
		if (left >= N) {
			int cnt = 0;
			for (int i=0; i<N; i++) {
				if (eggs[i][0] <= 0) cnt++;
			}
			if (cnt > max) max = cnt;
			return;
		}
		boolean flag = false;
		for (int i=0; i<N; i++) {
			if (i == left) continue;
			if (eggs[i][0] <= 0 || eggs[left][0] <= 0) continue;
			eggs[left][0] -= eggs[i][1];
			eggs[i][0] -= eggs[left][1];
			flag = true;
			dfs(left + 1);
			eggs[left][0] += eggs[i][1];
			eggs[i][0] += eggs[left][1];
		}
		if (!flag) dfs(left + 1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		eggs = new int[N][2];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			eggs[i][0] = Integer.parseInt(st.nextToken());
			eggs[i][1] = Integer.parseInt(st.nextToken());
		}
		
		max = 0;
		dfs(0);
		System.out.println(max);
		br.close();
	}

}
