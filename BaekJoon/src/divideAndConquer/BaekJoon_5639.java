package divideAndConquer;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_5639, 이진 검색 트리
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 일단 맨 앞에서 시작(target), target을 정답 배열 맨 뒤 인덱스에 추가하고 뒤 인덱스 갱신(pointer-1)
 * 	2. target을 기준으로 큰 숫자가 나올 때까지 우측으로 탐색
 * 		2.1 큰 숫자가 나오면 해당 숫자부터 target 기준 right, 그 이전 숫자들을 left
 * 		2.2 right가 있다면 right의 첫 숫자를  pointer 위치에 넣고
 * 		2.3 없다면 left의 첫 숫자를 pointer에 넣음
 * 		2.4 넣은 숫자를 새로운 target으로 다시 새로운 left, right를 찾음
 * 		2.5 만약 배열 끝까지 갔는데 못찾으면 다시 배열 맨 앞에서부터 target으로 시작
 *
 */
public class BaekJoon_5639 {
    static List<Integer> preOrder;
    static int[] postOrder;
    
    static void getPostOrder() {
        
    }

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String str;
	    
	    preOrder = new ArrayList<>();
	    while (true) {
	        str = br.readLine();
	        if (str == null || str.length() == 0) break;
	        preOrder.add(Integer.parseInt(str));
	    }
	    
	    System.out.println(preOrder);
	    int N = preOrder.size();
	    postOrder = new int[N];
	    
	    int target = 0;
	    int res = N;
	    while (res > 0) {
	        
	    }
	}

}
