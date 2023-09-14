package level03;

/**
 * Programmers_풍선 터뜨리기
 *	- 문제 분류 : 그리디 
 */
public class Programmers_풍선터뜨리기 {
	public static void main(String[] args) {
		Solution_풍선터뜨리기 s = new Solution_풍선터뜨리기();
		System.out.println(s.solution(new int[] { 9,-1,-5}));
		System.out.println(s.solution(new int[] {-16,27,65,-2,58,-92,-71,-68,-61,-33}));
	}
}

class Solution_풍선터뜨리기 {
	public int solution(int[] a) {
		/* 변수 초기화 */
        int N = a.length;
        int answer = N;
        int[] minLeft = new int[N];
        int[] minRight = new int[N];
        
        /* 메인 로직 */
        for (int i=0; i<N; i++) {
        	if (i == 0) {
        		minLeft[i] = a[i];
        		minRight[N - i - 1] = a[N - i - 1];
        		continue;
        	}
        	
        	minLeft[i] = Math.min(a[i], minLeft[i - 1]);
        	minRight[N - i - 1] = Math.min(a[N - i - 1], minRight[N - i]);
        }
        
        for (int i=0; i<N; i++) {
        	if (i == 0 || i == N - 1) continue;
        	if (minLeft[i - 1] < a[i] && minRight[i + 1] < a[i]) {
        		answer--;
        	}
        }
        
        /* 결과 반환 */
        return answer;
    }
}
