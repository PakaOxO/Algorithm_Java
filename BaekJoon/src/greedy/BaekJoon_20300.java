package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// º≠∞≠±Ÿ¿∞∏«
public class BaekJoon_20300 {
	static List<Long> lossPt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		lossPt = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			long loss = Long.parseLong(st.nextToken());
			lossPt.add(loss);
		}
		Collections.sort(lossPt);
		long max = Long.MIN_VALUE;
		for (int i=0; i<N/2; i++) {
			long sum;
			if (N % 2 == 0) {
				sum = lossPt.get(i) + lossPt.get(N - 1 - i);
			} else {
				sum = lossPt.get(i) + lossPt.get(N - 2 - i);
				if (lossPt.get(N - 1) > sum) sum = lossPt.get(N - 1);
			}
			if (sum > max) max = sum;
		}
		System.out.println(max);
		br.close();
	}

}
