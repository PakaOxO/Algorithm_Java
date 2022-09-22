package greedy;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1461, 도서관(HARD)
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 0을 기준으로 좌우, M개씩 묶어서 묶인 값 중 절댓값이 큰 값으로 2배(왕복)해서 answer에 더함
 * 	2. 만약 M개씩 묶다가 각 범위(양수, 음수)에서 남은 숫자들이 있다면 그것끼리(양수, 음수 각각) 묶어 그 중 절댓값이 큰 값을 2배(왕복)해서 answer에 더함
 * 	3. 마지막으로 양, 음수에서 절댓값이 큰 값을 찾아 answer에 절댓값
 *
 */
public class BaekJoon_1461 {
	static int N, M;
	static int[] books;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		books = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		books[0] = 0;
		for (int i=1; i<=N; i++) {
			books[i] = Integer.parseInt(st.nextToken());
			
		}
		br.close();
		Arrays.sort(books);
		
		int answer = 0;
		int lIdx = 0;
		while(true) {
			if (books[lIdx] == 0) break;
			answer += Math.abs(books[lIdx]) * 2;
			for (int i=0; i<M; i++) {
				lIdx++;
				if (books[lIdx] == 0) break;
			}
		}
		
		int rIdx = N;
		while(true) {
			if (books[rIdx] == 0) break;
			answer += books[rIdx] * 2;
			for (int i=0; i<M; i++) {
				rIdx--;
				if (books[rIdx] == 0) break;
			}
		}
		
		// ABS 큰놈 찾아서 빼기
		if (Math.abs(books[0]) > books[N]) answer += books[0];
		else answer -= books[N];
		
		System.out.println(answer);
	}

}
