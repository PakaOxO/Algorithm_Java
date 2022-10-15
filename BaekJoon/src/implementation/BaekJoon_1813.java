package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//  논리학 교수
public class BaekJoon_1813 {
	private static int[] cnt = new int[51];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = Integer.MIN_VALUE;
		for (int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			cnt[num]++;
			max = Math.max(max, num);
		}
		
		int result = -1;
		for (int i=max; i>=0; i--) {
			if (cnt[i] == i) {
				result = cnt[i];
				break;
			}
		}
		System.out.println(result);
		br.close();
	}

}
