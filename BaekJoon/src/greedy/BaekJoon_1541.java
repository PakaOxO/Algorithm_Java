package greedy;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1541, 잃어버린 괄호
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 덧셈 연산을 먼저 끝내 숫자를 최대한 크게 만든 뒤 뺄셈 연산을 하면 되지 않을까...
 *
 */
public class BaekJoon_1541 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<String> q = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		
		String input = br.readLine();
		br.close();
		
		int len = input.length();
		int num = 0;
		for (int i=0; i<len; i++) {
			char c = input.charAt(i);
			if (c >= '0' && c <= '9') num = num * 10 + (int)(c - '0');
			else {
				q.offer(String.valueOf(num));
				num = 0;
				q.offer(String.valueOf(c));
			}
		}
		if (num != 0) q.offer(String.valueOf(num));
		
		int val = Integer.parseInt(q.poll());
		while (!q.isEmpty()) {
			char c = q.poll().charAt(0);
			if (c == '+') {
				val += Integer.parseInt(q.poll());
			} else {
				q2.offer(val);
				val = Integer.parseInt(q.poll());
			}
		}
		q2.offer(val);
		
		int answer = q2.poll();
		while (!q2.isEmpty()) {
			answer -= q2.poll();
		}
		System.out.println(answer);
	}

}
