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
		
		for (int i=0; i<len; i++) {
			int count = 0;
			for (int j=i+1; j<len; j++) {
				count++;
				if (prices[j] < prices[i]) break;
			}
			answer[i] = count;
		}
		
		return answer;
	}
}