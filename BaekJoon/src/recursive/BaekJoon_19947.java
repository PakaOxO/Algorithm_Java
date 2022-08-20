package recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 투자의 귀재 배주형
public class BaekJoon_19947 {
	static int Y;
	static int[] money;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		money = new int[Y+1];
		money[0] = H;
		
		for (int i=1; i<=Y; i++) {
			money[i] = (int)(money[i-1] * 1.05);
			if (i >= 3) {
				money[i] = Math.max(money[i], (int)(money[i-3] * 1.2));
			}
			if (i >= 5) {
				money[i] = Math.max(money[i], (int)(money[i-5] * 1.35));
			}
		}
		
		System.out.println(money[Y]);
		br.close();
	}

}
