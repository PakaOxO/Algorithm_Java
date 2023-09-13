package heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BaekJoon_15903, 카드 합체 놀이
 *  - 문제 분류 : 자료 구조(힙)
 */

public class BaekJoon_15903 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] cards = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        
        Solution_카드합체놀이 s = new Solution_카드합체놀이();
        System.out.println(s.solution(N, M, cards));
    }
}

class Solution_카드합체놀이 {
    long solution(int n, int m, int[] cards) {
        /* 변수 초기화 */
        long answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        
        for (int card : cards) {
            pq.offer((long)card);
            answer += card;
        }
        
        /* 메인 로직 */
        while (m > 0) {
            long sum = pq.poll() + pq.poll();
            pq.offer(sum);
            pq.offer(sum);
            answer += sum;
            m--;
        }
        
        /* 결과 반환 */
        return answer;
    }
}