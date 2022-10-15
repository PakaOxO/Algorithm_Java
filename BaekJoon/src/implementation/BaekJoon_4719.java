package implementation;

import java.io.*;
import java.util.*;


public class BaekJoon_4719 {
	static int[] arr;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		arr = new int[W];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		for (int i=1; i<=H; i++) {
			boolean flag = false;
			int cnt = 0;
			for (int j=0; j<W; j++) {
				if (flag) {
					if (arr[j] < i) cnt++;
					else {
						answer += cnt;
						cnt = 0;
					}
				} else {
					if (arr[j] >= i) flag = true;
				}
			}
		}
		
		System.out.println(answer);
		br.close();
	}

}
