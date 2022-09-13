package dp;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2565, 전깃줄
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 위치의 최대 개수는 500개이다.
 * 		1.1 길이가 501인 배열을 만들어 입력을 받으면서 인덱스의 위치는 A전봇대, 인덱스에 해당하는 값은 연결된 전봇대로 입력받는다.
 * 	2. 전깃줄 배열을 한번 더 순회하면서 교차된 전깃줄의 개수를 찾는다.
 * 		2.1 전깃줄이 교차되기 위한 조건은 이전 전봇대에서 연결된 전봇대의 번호가 자신과 연결된 전봇대보다 번호가 클 경우..
 * 		2.2 
 *
 */
public class BaekJoon_2565 {
	static int[] arr;
	static int[] cnt;
	static boolean[][] isConnected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[501];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		
		cnt = new int[501];
		isConnected = new boolean[501][501];
		for (int i=1; i<=500; i++) {
			for (int j=i+1; j<=500; j++) {
				if (arr[i] == 0 || arr[j] == 0) continue;
				if (arr[j] < arr[i]) {
					cnt[i]++;
					cnt[j]++;
					isConnected[i][j] = true;
					isConnected[j][i] = true;
				}
			}
		}
		int answer = 0;
		while (true) {
			int maxIdx = 0;
			for (int i=1; i<=500; i++) {
				if (cnt[i] > 0 && cnt[i] >= cnt[maxIdx]) maxIdx = i;
			}
			if (maxIdx == 0) break;
			
			answer++;
			cnt[maxIdx] = 0;
			for (int i=1; i<=500; i++) {
				if (i == maxIdx) continue;
				if (isConnected[maxIdx][i]) {
					isConnected[maxIdx][i] = isConnected[i][maxIdx] = false;
					cnt[i]--;
				}
			}
		}
		System.out.println(answer);
		br.close();
	}

}
