package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Flatten
public class SWEA_1208 {
	static int[] cnt;
	
	static void flatten() {
		for (int i=100; i>=0; i--) {
			if (cnt[i] > 0 && (i - 1) > 0) {
				cnt[i]--;
				cnt[i-1]++;
				break;
			}
		}
		for (int j=1; j<101; j++) {
			if (cnt[j] > 0 && j+1 < 101) {
				cnt[j]--;
				cnt[j+1]++;
				break;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		for (int i=1; i<=T; i++) {
			int N = Integer.parseInt(br.readLine());
			cnt = new int[101];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<100; j++) {
				cnt[Integer.parseInt(st.nextToken())]++; 
			}
			
			while (N > 0) {
				flatten();
				N--;
			}
			
			int minHeight = 0, maxHeight = 0;
			for (int j=1; j<101; j++) {
				if (cnt[j] > 0) {
					minHeight = j;
					break;
				}
			}
			for (int j=100; j>=0; j--) {
				if (cnt[j] > 0) {
					maxHeight = j;
					break;
				}
			}
			sb.append("#" + i + " " + (maxHeight - minHeight) + "\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
