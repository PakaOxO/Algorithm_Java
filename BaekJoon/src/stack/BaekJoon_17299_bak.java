package stack;

import java.io.*;
import java.util.*;

// 오등큰수
public class BaekJoon_17299_bak {
	static int[] arr;
	static int[] cnt;
	static int[] answer;
	
	static int[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		answer = new int[N];
		cnt = new int[1000001];
		for (int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			cnt[num]++;
			arr[i] = num;
		}
		
		list = new int[1000001];
		int numCntMax = 0;
		for (int i=N-1; i>=0; i--) {
			if (cnt[arr[i]] >= cnt[numCntMax]) {
				numCntMax = arr[i];
				answer[i] = -1;
			} else {
				for (int j=cnt[arr[i]] + 1; j<=cnt[numCntMax]; j++) {
					if (list[j] > 0) {
						answer[i] = list[j];
						break;
					}
				}
			}
			list[cnt[arr[i]]] = arr[i];
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			if (i < N - 1) sb.append(answer[i]).append(" ");
			else sb.append(answer[i]);
		}
		System.out.println(sb);
		br.close();
	}

}
