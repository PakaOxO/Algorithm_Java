package stack;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1918, 후위 표기식 (재풀이)
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 주어진 중위 표기식을 후위 표기식으로 변환하는 문제
 * 
 * 	2. 변환 프로세스
 * 		2.1 숫자(A-Z)는 바로 출력값에 담는다.
 * 		2.2 연산자(괄호 포함)은 우선 순위에 따라 아래와 같은 로직을 따른다.
 * 			2.2.1 현재 주어진 연산자가 stack top 연산자보다 우선순위가 높을 경우, push
 * 			2.2.2 작거나 같을 경우, 현재 연산자의 top보다 커질 때까지 stack 내부 연산자를 pop하여 출력값에 연산자를 담음.
 * 			2.2.3 위 과정으로 현자 연산자의 우선 순위가 커지면 stack에 push
 * 			2.2.4 만약 주어진 연산자가 ')'(닫는 괄호)라면 여는 괄호가 나올 때까지 stack 내부 모든 연산자를 pop하여 출력값에 담음.
 * 		2.3 연산자 우선순위
 * 			2.3.1 스택 밖, '(' > '*' = '/' > '+' = '-'
 * 			2.3.2 스택 안, '*' = '/' > '+' = '-' > '('
 * 		
 * 	3. 프로세스가 종료되고 스택에 남은 모든 연산자를 출력값에 담음.
 * 
 */
public class BaekJoon_1918 {
	static Stack<Character> stack = new Stack<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 'A' && c <= 'Z') sb.append(c);
			else {
				if (c == ')') {
					while (true) {
						if (stack.peek() == '(') {
							stack.pop();
							break;
						}
						sb.append(stack.pop());
					}
					continue;
				}
				int cWeight = 0;
				if (c == '+' || c == '-') cWeight = 1;
				else if (c == '*' || c == '/') cWeight = 2;
				else cWeight = 3;
				
				while (stack.size() > 0) {
					char top = stack.peek();
					int topWeight = 0;
					if (top == '+' || top == '-') topWeight = 1;
					else if (top == '*' || top == '/') topWeight = 2;
					else topWeight = 0;
					
					if (topWeight >= cWeight) {
						sb.append(stack.pop());
					} else break;
				}
				stack.push(c);
			}
		}
		while (stack.size() > 0) sb.append(stack.pop());
		System.out.println(sb);
		br.close();
	}

}
