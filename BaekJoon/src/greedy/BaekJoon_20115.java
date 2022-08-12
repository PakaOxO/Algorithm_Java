package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 에너지 드링크
public class BaekJoon_20115 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double max = Integer.MIN_VALUE;
		double acc = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			double drink = Double.parseDouble(st.nextToken());
			acc += drink;
			if (drink > max) max = drink;
		}
		double answer = (acc + max) / 2;
		System.out.println(answer);
		br.close();
	}

}
