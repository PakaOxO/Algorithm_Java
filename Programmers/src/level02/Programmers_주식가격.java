package level02;

import java.util.Arrays;
import java.util.Stack;

public class Programmers_주식가격 {

	public static void main(String[] args) {
		Solution8 s = new Solution8();
		System.out.println(Arrays.toString(s.solution(new int[] { 1, 2, 3, 2, 3 })));
		System.out.println(Arrays.toString(s.solution(new int[] { 1, 2, 3, 2, 1 })));
	}

}


class Solution8 {
	public int[] solution(int[] prices) {
		int len = prices.length;
		int[] answer = new int[len];
		Stack<int[]> stack = new Stack<>();
		
		for (int i=len - 1; i>=0; i--) {
			while (stack.size() > 0 && prices[i] <= stack.peek()[0]) {
				stack.pop();
			}
			if (stack.size() < 1 || prices[i] < stack.peek()[0]) {				
				stack.push(new int[] { prices[i], i });
			}
			
			if (stack.peek()[1] == i) {
				answer[i] = len - i - 1;
			} else {				
				answer[i] = stack.peek()[1] - i;
			}
		}
		
		return answer;
	}
}