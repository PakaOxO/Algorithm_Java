package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ¡÷¿Øº“
public class BaekJoon_13305 {
	static long[] distance;
	static long[] price;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		distance = new long[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		long dTotal = 0;
		for (int i=1; i<N; i++) {
			long d = Integer.parseInt(st.nextToken());
			distance[i] = d;
			dTotal += d;
		}
		
		price = new long[N+1];
		st = new StringTokenizer(br.readLine());
		long pMin = Integer.MAX_VALUE;
		for (int i=0; i<N; i++) {
			long p = Integer.parseInt(st.nextToken());
			price[i] = p;
			if (p < pMin) pMin = p;
		}
		
		long minPrice = price[0];
		long d = 0;
		long answer = 0;
		for (int i=1; i<=N; i++) {
			dTotal -= distance[i];
			d += distance[i];
			if (minPrice > price[i]) {
				answer += (minPrice * d);
				minPrice = price[i];
				d = 0;
				if (minPrice == pMin) {
					answer += pMin * dTotal;
					break;
				}
				continue;
			}
		}
		System.out.println(answer);
		br.close();
	}

}
