package logic;

import java.util.*;
import java.io.*;

// 누적 합 
public class BaekJoon_11659 {
	static int N;
	static int[] arr;
	static int sum;
	
	static int getAcc(int a, int b) {
		if (a == 0) return arr[b];
		return arr[b] - arr[a - 1];
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		int acc = 0;
		for (int i=0; i<N; i++) {
			acc += Integer.parseInt(st.nextToken());
			arr[i] = acc;
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			sb.append(getAcc(a, b)).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
