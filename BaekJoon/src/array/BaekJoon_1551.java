package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수열의 변화
public class BaekJoon_1551 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), ",");
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=0; i<K; i++) {
			for (int j=0; j<arr.length-1-i; j++) {
				arr[j] = arr[j+1] - arr[j];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N-K; i++) {
			sb.append(arr[i] + ",");
		}
		System.out.println(sb.deleteCharAt(sb.length() -1));
		br.close();
	}

}
