package greedy;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_16953, A -> B
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. dp로 풀려했으나 최대 숫자 범위가 10만인지라 메모리 초과
 * 	2. dfs로 풀었으나 5%대에서 fail -> 아마 최소, 최대 입력값인 1과 10만이 입력되었을때 overflow가 나오는 것 같음
 * (중복 호출의 문제가 있음, 항상 바운더리 테케를 제출 전에 테스트해보는 습관을 가지자...)
 * 
 * 	3. bfs로 재풀이 -> int 오버플로우로 틀림, long으로 바꿔 해결 
 *
 */
public class BaekJoon_16953 {
    static class Node {
        long val;
        int depth;
        
        Node(long val, int depth) {
            this.val = val;
            this.depth = depth;
        }
    }
    
    static long answer;
    
	static void bfs(long num, int B) {
	    Queue<Node> q = new LinkedList<>();
	    q.offer(new Node(num, 1));
	    
	    while (!q.isEmpty()) {
	        Node curr = q.poll();
	        
	        long n1 = curr.val * 2;
	        if (n1 <= B) {
	            if (n1 == B) {
	                answer = curr.depth + 1;
	                return;
	            }
	            q.offer(new Node(n1, curr.depth + 1));
	        }
	        
	        long n2 = curr.val * 10 + 1;
	        if (n2 <= B) {
	            if (n2 == B) {
	                answer = curr.depth + 1;
	                return;
	            }
	            q.offer(new Node(n2, curr.depth + 1));
	        }
	    }
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		br.close();
		
		bfs(A, B);
		System.out.println(answer == 0 ? -1 : answer);
	}

}
