package level02;

import java.util.*;

class Solution6 {
    public int[] solution(String[] operations) {
    	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    	Queue<Integer> dump = new LinkedList<>();
    	
    	for (int i=0; i<operations.length; i++) {
    		StringTokenizer st = new StringTokenizer(operations[i]);
    		char op = st.nextToken().charAt(0);
    		int val = Integer.parseInt(st.nextToken());
    		
    		if (op == 'I') {
    			maxHeap.offer(val);
    			minHeap.offer(val);
    		} else {
    			if (maxHeap.size() < 1) continue;
    			if (val > 0) {
    				int max = maxHeap.poll();
    				while (!minHeap.isEmpty()) {
    					dump.offer(minHeap.poll());
    				}
    				while (!dump.isEmpty()) {
    					int num = dump.poll();
    					if (num != max) {    						
    						minHeap.offer(num);
    					}
    				}
    			} else {
    				int min = minHeap.poll();
    				while (!maxHeap.isEmpty()) {
    					dump.offer(maxHeap.poll());
    				}
    				while (!dump.isEmpty()) {
    					int num = dump.poll();
    					if (num != min) {    						
    						maxHeap.offer(num);
    					}
    				}
    			}
    		}
    	}
        
    	if (maxHeap.isEmpty()) {
    		return new int[] { 0, 0 };
    	} else {
    		return new int[] { maxHeap.peek(), minHeap.peek() };
    	}
    }
}

public class 이중우선순위큐 {

	public static void main(String[] args) throws Exception {
		Solution6 s = new Solution6();
		System.out.println(Arrays.toString(s.solution(new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));
		System.out.println(Arrays.toString(s.solution(new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));;
	}

}
