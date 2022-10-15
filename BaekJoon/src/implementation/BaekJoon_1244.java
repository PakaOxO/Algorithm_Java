package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스위치 켜고 끄기
public class BaekJoon_1244 {
	static int[] sw;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		sw = new int[N];
		for (int i=0; i<N; i++) {
			sw[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			if (s == 1) {
				for (int j=t-1; j<N; j+=t) {
					sw[j] = (sw[j] == 1) ? 0 : 1;
				}
			} else {
				int left = t-1, right = t-1;
				while (left >= 0 && right < N) {
					if (sw[left] != sw[right]) break;
					left--;
					right++;
				}
				left++; right--;
				for (int j=left; j<=right; j++) {
					sw[j] = (sw[j] == 1) ? 0 : 1;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			if ((i + 1) % 20 != 0) sb.append(sw[i] + " ");
			else sb.append(sw[i] + "\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
