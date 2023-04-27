package level02;

import java.util.Arrays;

class Solution5 {
    public int[] solution(int n, int s) {
    	int num = s;
    	int sum = 0;
    	
    	int[] answer = new int[n];
    	int idx = 0;
		while (num > 0 && n > 0) {
			int share = num / (n--);
			if (share == 0) return new int[] { -1 };
			answer[idx++] = share;
			num -= share;
			sum += share;
		}
        return sum == s ? answer : new int[] { -1 };
    }
}

public class 최고의_집합 {

	public static void main(String[] args) {
		Solution5 s = new Solution5();
		System.out.println(Arrays.toString(s.solution(2, 9)));
		System.out.println(Arrays.toString(s.solution(2, 1)));
		System.out.println(Arrays.toString(s.solution(2, 8)));
		System.out.println(Arrays.toString(s.solution(3, 9)));
		System.out.println(Arrays.toString(s.solution(4, 11)));
		System.out.println(Arrays.toString(s.solution(1, 11)));
		System.out.println(Arrays.toString(s.solution(10000, 100000000)));
	}

}
