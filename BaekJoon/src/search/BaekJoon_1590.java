package search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 캠핑가는 영식 재풀이
public class BaekJoon_1590 {
	static int T, S, I, C;
	static int answer;
	static int lostCnt = 0;
	
	static void binarySearch() {
		// 이진 탐색 범위는 버스의 운행 수(0 ~ C)
		int left = 0;
		int right = C - 1;
		
		// 막차시간보다 늦게 도착한다면 탈 수 있는 버스는 없지만 운행 노선이 2개 이상일 수 있으므로
		// 놓친 버스 카운팅
		int endTime = S + ((C - 1) * I);
		if (T > endTime) {
			lostCnt++;
			return;
		}
		
		while (left <= right) {
			int mid = (left + right) / 2;
			int apartTime = S + (mid * I);
			if (apartTime < T) {
				left = mid + 1;
			} else {
				// 운행하는 버스가 2대 이상일 수 있으므로 기다리는 시간의 최소값 저장
				answer = Math.min(apartTime - T, answer);
				right = mid - 1;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		answer = Integer.MAX_VALUE;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			I = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			// 입력 요소를 고려해 가장 적게 기다리는 시간 도출
			// 이전 노선에서 기다리는 시간이 없는 버스가 있었다면 검색 필요 X
			if (answer != 0) binarySearch();
		}
		// 놓친 버스가 노선 수랑 동일하다면 탈 수 있는 버스는 없음
		if (lostCnt == N) answer = -1;
		System.out.println(answer);
		br.close();
	}

}
