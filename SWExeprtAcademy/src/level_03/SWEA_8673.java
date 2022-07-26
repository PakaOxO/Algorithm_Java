package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 코딩 토너먼트 1
public class SWEA_8673 {
	static int sum;
	
	public static int[] game(int[] arr) {
		if (arr.length == 1) return arr;
		
		int[] nextArr = new int[arr.length / 2];
		for (int i=0; i<arr.length; i+=2) {
			if (arr[i] > arr[i+1]) {
				nextArr[i/2] = arr[i];
				sum += (arr[i] - arr[i+1]);
			}
			else {
				nextArr[i/2] = arr[i+1];
				sum += (arr[i+1] - arr[i]);
			}
		}
		return game(nextArr);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=1; i<=T; i++) {
			int K = Integer.parseInt(br.readLine());
			int KK = (int)Math.pow(2, K);
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] input = new int[KK];
			for (int j=0; j<KK; j++) {
				input[j] = Integer.parseInt(st.nextToken());
			}
			sum = 0;
			game(input);
			System.out.printf("#%d %d\n", i, sum);
		}
	}

}
