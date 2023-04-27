package level02;

import java.util.Arrays;

class Solution3 {
    public int[] solution(int brown, int yellow) {
        int B = brown / 2 - 2, Y = yellow;
        int c = 1, r = yellow;
        while (c <= r) {
        	if (Y % c == 0) {
        		r = Y / c;
        		if (r + c == B) break;
        	}
        	c++;
        }
        return new int[] { r + 2, c + 2 };
    }
}

public class 카펫 {

	public static void main(String[] args) {
		Solution3 s = new Solution3();
		System.out.println(Arrays.toString(s.solution(10, 2)));
		System.out.println(Arrays.toString(s.solution(8, 1)));
		System.out.println(Arrays.toString(s.solution(24, 24)));
	}

}
