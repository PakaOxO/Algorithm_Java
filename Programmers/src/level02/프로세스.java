package level02;

import java.util.*;

class Solution7 {
	class Node {
		int idx;
		int val;
		
		Node (int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
		
		public String toString() {
			return "Node(" + this.idx + ", " + this.val + ")";
		}
	}
	
    public int solution(int[] priorities, int location) {
        Queue<Node> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int i=0; i<priorities.length; i++) {
        	q.offer(new Node(i, priorities[i]));
        	pq.offer(priorities[i]);
        }
        
        int answer = 1;
        while (!q.isEmpty()) {
        	Node curr = q.poll();
        	if (curr.val >= pq.peek()) {	
        		if (curr.idx == location) {
        			return answer;
        		}
        		answer++;
        		pq.poll();
        	} else {
        		q.offer(curr);
        	}
        }
        return answer;
    }
}

public class 프로세스 {

	public static void main(String[] args) {
		Solution7 s = new Solution7();
		System.out.println(s.solution(new int[] { 2, 1, 3, 2 }, 2));
		System.out.println(s.solution(new int[] { 1, 1, 9, 1, 1, 1 }, 0));
	}

}
