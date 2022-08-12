package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// µ¿Àü 0
public class BeakJoon11047 {
	static long[] money;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long price = Long.parseLong(st.nextToken());
		money = new long[N];
		for (int i=0; i<N; i++) {
			money[i] = Long.parseLong(br.readLine());
		}
		int answer = 0;
		for (int i=N-1; i>=0; i--) {
			if (money[i] > price) continue;
			answer += (int)(price / money[i]);
			price %= money[i];
		}
		System.out.println(answer);
		br.close();
	}

}
