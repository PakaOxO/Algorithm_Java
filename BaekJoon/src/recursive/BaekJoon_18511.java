package recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 큰 수 구성하기
public class BaekJoon_18511 {
	static int[] nums;
	static long N;
	static int K;
	static long answer;
	
	static void getMax(long num) {
		if (num > N) return;
		if (num > answer) answer = num;
		for (int i=0; i<K; i++) {
			getMax(num * 10 + nums[i]);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		nums = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<K; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		getMax((long)0);
		System.out.println(answer);
		br.close();
	}

}
