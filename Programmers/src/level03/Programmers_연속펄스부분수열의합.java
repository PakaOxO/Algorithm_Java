package level03;

/**
 * Programmers_연속 펄스 부분 수열의 합
 * 	- 문제 분류 : 그리디, 누적합
 *
 */

public class Programmers_연속펄스부분수열의합 {
	public static void main(String[] args) {
		Solution_연속펄스부분수열의합 s = new Solution_연속펄스부분수열의합();
		System.out.println(s.solution(new int[] {2, 3, -6, 1, 3, -1, 2, 4}));
	}
}

class Solution_연속펄스부분수열의합 {
	public long solution(int[] sequence) {
		/* 변수 초기화 */
		long answer = 0;
		int N = sequence.length;
		long[] acc = new long[N + 1];
		long min = Long.MAX_VALUE;
		long max = Long.MIN_VALUE;
		int minIdx = -1;
		int maxIdx = -1;
		
		/* 메인 로직 */
		for (int i=0; i<N; i++) {
			acc[i + 1] += acc[i] + ((i % 2 == 1 ? 1 : -1) * sequence[i]);
		}
		
		// 누적 합의 최대, 최소값 및 해당 인덱스를 저장
		for (int i=0; i<=N; i++) {
			if (acc[i] > max) {
				max = acc[i];
				maxIdx = i;
			}
			if (acc[i] < min) {
				min = acc[i];
				minIdx = i;
			}
		}
		
		// 최대값과 최소값의 위치가 같으면 뺄 필요가 없음, 다르다면 두 차이의 절대값을 answer에 반환
		answer = maxIdx != minIdx ? Math.abs(max - min) : max;
		
		/* 정답 반환 */
		return answer;
	}
}