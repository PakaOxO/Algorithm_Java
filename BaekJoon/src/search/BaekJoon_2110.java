package search;

import java.io.*;
import java.util.*;

// 공유기 설치
public class BaekJoon_2110 {
	static int N, C;
	static int[] house;
	static int answer;
	
	static void binarySearch(int left, int right) {
		
		while (left < right) {
			int mid = (left + right) / 2;
			int cnt = 1;
			int prev = house[0];
			for (int i=1; i<N; i++) {
				if (house[i] - prev >= mid) {
					cnt++;
					prev = house[i];
				}
			}
			
			if (cnt < C) {
				right = mid;
			} else {
				left = mid + 1;
				answer = mid;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		house = new int[N];
		for (int i=0; i<N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(house);
		
		if (C > 2) {
			binarySearch(1, house[N-1] - house[0]);
		} else {
			answer = house[N - 1] - house[0];
		}
		
		System.out.println(answer);
		br.close();
	}

}
