package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 블랙잭
public class BaekJoon_2798 {
	static int[] cards;
	static int max;
	
	static int N;
	static int M;
	
	static List<Integer> list;

	static void sumMax(int idx) {
		if (list.size() == 3) {
			int sum = 0;
			for (int i=0; i<3; i++) {
				sum += list.get(i);
			}
			if (sum <= M) max = Math.max(sum, max);
			return;
		}
		if (idx == N) return;
		
		for (int i=idx; i<N; i++) {
			list.add(cards[i]);
			sumMax(i + 1);
			list.remove(list.size()-1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cards = new int[N];
		
		st = new StringTokenizer(br.readLine());
		list = new ArrayList<>();
		for (int i=0; i<N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		sumMax(0);
		System.out.println(max);
	}

}
