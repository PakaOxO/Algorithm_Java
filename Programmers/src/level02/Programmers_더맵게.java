package level02;

import java.util.PriorityQueue;

public class Programmers_더맵게 {
    public static void main(String[] args) {
    	Solution_더맵게 s = new Solution_더맵게();
        System.out.println(s.solution(new int[] {1, 2, 3, 9, 10, 12}, 7));
    }
}

class Solution_더맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.offer(s);
        }

        int answer = 0;
        while (pq.size() > 1 && (int)pq.peek() < K) {
            int min = pq.poll();
            int min2 = pq.poll();
            pq.offer(min + (min2 * 2));
            answer++;
        }
        return pq.peek() >= K ? answer : -1;
    }
}