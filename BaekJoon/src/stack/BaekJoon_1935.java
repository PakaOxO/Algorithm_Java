package stack;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1935, 후위 표기식 2
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 후위 표기식으로 이미 변환이 되어있으므로 앞에서부터 읽어가면서 계산
 * 	2. 먼저 모든 입력을 받아 문자열의 각 문자(알파벳)에 해당하는 숫자를 저장(nums)
 * 	3. 문자열을 앞에서 순차적으로 돌며 연산
 * 		3.1 문자열을 앞에서부터 읽어가며 숫자이면 stack에 push
 * 		3.2 수식이면 stack에서 숫자 2개를 꺼내 계산(순서 주의, stack 위의 숫자가 연산 뒤에 위치)
 *
 */
public class BaekJoon_1935 {
	static Stack<Double> stack = new Stack<>();
	static int[] nums;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		nums = new int[N];
		for (int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if (c != '+' && c != '-' && c != '*' && c != '/') {
				stack.push((double)nums[c - 'A']);
				continue;
			}
			if (c == '+') {
				double num2 = stack.pop();
				double num1 = stack.pop();
				stack.push(num1 + num2);
			} else if (c == '-') {
				double num2 = stack.pop();
				double num1 = stack.pop();
				stack.push(num1 - num2);
			} else if (c == '*') {
				double num2 = stack.pop();
				double num1 = stack.pop();
				stack.push(num1 * num2);
			} else {
				double num2 = stack.pop();
				double num1 = stack.pop();
				stack.push(num1 / num2);
			}
		}
		System.out.printf("%.2f", stack.pop());
		br.close();
	}

}
