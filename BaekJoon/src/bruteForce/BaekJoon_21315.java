package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_21315, 카드 섞기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 먼저 (2, K) 섞기를 수행하는 메서드를 구현한다.
 *
 */
public class BaekJoon_21315 {
	static int N, maxK;
	static Deque<Integer> cards;
	static int[] result;
	static int[] comb;
	
	static boolean check() {
		int idx = 0;
		while (cards.size() > 0) {
			if (result[idx++] != cards.removeFirst()) return false;
		}
		return true;
	}
	
	static void resetCards() {
		cards = new LinkedList<>();
		for (int i=1; i<=N; i++) {
			cards.add(i);
		}
	}
	
	static void shuffle(int K) {
		Deque<Integer> q = new LinkedList<>();
		int cnt = (int)Math.pow(2, K);
		for (int i=0; i<cnt; i++) {
			q.addFirst(cards.removeLast());
		}
		for (int i=2; i<=K+1; i++) {
			cnt = (int)Math.pow(2, K - i + 1);
			for (int j=0; j<cnt; j++) {
				q.addFirst(q.removeLast());
			}
			for (int j=0; j<cnt; j++) {
				cards.addFirst(q.removeLast());
			}
		}
		cards.addFirst(q.removeFirst());
	}
	
	static void dfs(int depth) {
		if (depth == 2) {
			shuffle(comb[0]);
			shuffle(comb[1]);
			if (check()) {
				System.out.println(comb[0] + " " + comb[1]);
				System.exit(0);
			}
			resetCards();
			return;
		}
		
		for (int i=1; i<=maxK; i++) {
			comb[depth] = i;
			dfs(depth + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int m = 2;
		while (m < N) {
			maxK++;
			m *= 2;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		result = new int[N];
		for (int i=0; i<N; i++) {
			result[i] = Integer.parseInt(st.nextToken());
		}
		
		resetCards();
		comb = new int[2];
		dfs(0);
		
		br.close();
	}

}
