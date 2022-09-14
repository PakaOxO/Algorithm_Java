package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_16637, 괄호 추가
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 괄호 선택은 먼저 계산할 수식을 선택하는 것과 같으므로 먼저 계산할 연산자를 선택하는 조합을 탐색
 * 	2. 연산자를 선택하는 조합에서 연속된 연산자는 선택할 수 없는데 연속된 연산자를 선택하는 것은 중첩괄호를 의미하기 때문
 * 	3. 수식의 가장 앞부터 완전탐색을 하면서 연산자인지 확인하고 선택할지 말지 고르며 조합을 찾음
 *
 */
public class BaekJoon_16637 {
	static int N;
	static char[] input;
	static boolean[] selected;
	static Deque<Integer> deque;
	static int max;
	
	static void cal() {
		for (int i=0; i<N; i++) {
			char c = input[i];
			if (selected[i]) {
				int op = (int)c;
				if (op == 43) deque.addLast(deque.removeLast() + (int)(input[i + 1] - '0'));
				else if (op == 45) deque.addLast(deque.removeLast() - (int)(input[i + 1] - '0'));
				else if (op == 42) deque.addLast(deque.removeLast() * (int)(input[i + 1] - '0'));
				i++;
			} else {
				if (i % 2 == 0) deque.addLast((int)(c - '0'));
				else deque.addLast((int)c);
			}
		}
		
		int result = deque.removeFirst();
		while (deque.size() > 0) {
			int op = deque.removeFirst();
			if (op == 43) result = result + deque.removeFirst();
			else if (op == 45) result = result - deque.removeFirst();
			else if (op == 42) result = result * deque.removeFirst();
		}
		max = Math.max(max, result);
	}
	
	static void dfs(int start) {
		cal();
		
		for (int i=start; i<N; i+=2) {
			if (i - 2 > 0 && selected[i - 2]) continue;
			selected[i] = true;
			dfs(i + 2);
			selected[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = br.readLine().toCharArray();
		
		deque = new LinkedList<>();
		selected = new boolean[N];
		max = Integer.MIN_VALUE;
		dfs(1);
		
		System.out.println(max);
		br.close();
	}

}
