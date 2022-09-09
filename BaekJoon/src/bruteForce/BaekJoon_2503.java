package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2503, 숫자 야구 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 1~9의 숫자는 각각 한번씩 세개만 쓰이므로 먼저 사용되는 세 개의 숫자를 찾는 것을 목표로 탐색
 * 		1.1 1~9에서 3개의 숫자를 뽑는 조합의 가지수는 9C3 = 9 8 7 / 3 2 1 = 84가지
 * 
 * 	2. 나올 수 있는 수의 조합마다 질문과 비교하며 스트라이크와 볼의 개수를 답변과 비교 
 * 		2.1 답변과 같으면 나머지 답변과 비교
 * 		2.2 답변과 다르면 나올 수 있는 수가 아니므로 다음 탐색으로 넘어가 새로운 수를 찾음
 * 		2.3 모든 답변과 같으면 등장할 수 있는 수이므로 answer + 1
 * 
 * 	3. 모든 탐색 + 비교를 거친 뒤 계산되는 answer를 출
 *
 */
public class BaekJoon_2503 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] input = new int[N][3];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
			input[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		for (int i=1; i<=9; i++) {
			for (int j=1; j<=9; j++) {
				if (i == j) continue;
				for (int k=1; k<=9; k++) {
					if (i == k || j == k) continue;
					
					boolean flag = true;
					for (int l=0; l<N; l++) {
						int strike = 0;
						int ball = 0;
						
						int guess = input[l][0];
						if (guess / 100 == i) strike++;
						if (guess / 10 % 10 == j) strike++;
						if (guess % 10 == k) strike++;
						if (i == guess / 10 % 10 || i == guess % 10) ball++;
						if (j == guess / 100 || j == guess % 10) ball++;
						if (k == guess / 100 || k == guess / 10 % 10) ball++;
						
						if (!(strike == input[l][1] && ball == input[l][2])) {
							flag = false;
							break;
						}
					}
					if (flag) answer++;
				}
			}
		}
		System.out.println(answer);
		br.close();
	}

}
