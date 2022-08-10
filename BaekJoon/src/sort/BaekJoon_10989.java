package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 수 정렬하기 3
public class BaekJoon_10989 {
	
	static void countingSort(int[] arr, int max) {
		int[] temp = new int[max+1];
		for (int i=0; i<arr.length; i++) {
			temp[arr[i]]++;
		}
		int acc = 0;
		for (int i=0; i<max+1; i++) {
			acc += temp[i];
			temp[i] = acc;
		}
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for (int i=0; i<max+1; i++) {
			while (temp[i] - cnt > 0) {
				sb.append(i+"\n");
				cnt++;
			}
		}
		System.out.println(sb.toString().trim());
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		
		int max = Integer.MIN_VALUE;
		for (int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num > max) max = num;
			input[i] = num;
		}
		countingSort(input, max);
		br.close();
	}

}
