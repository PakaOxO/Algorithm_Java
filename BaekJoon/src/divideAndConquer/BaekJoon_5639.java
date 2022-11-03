package divideAndConquer;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_5639, 이진 검색 트리
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 처음 입력 배열(preOrder)의 왼쪽 끝 인덱스를 left, 오른쪽 끝 인덱스를 right로 재귀 시작
 *  2. 재귀 시작시 left의 preOrder 값을 pointer(postOrder 뒤쪽 인덱스)의 위치에 저장
 * 	3. 이후 현재의 left 숫자를 기준으로 더 큰 숫자가 나올 때까지 우측으로 탐색
 * 		2.1 큰 숫자가 나오면 해당 위치를 mid(초기값 -1)라 생각하고
 *          2.1.1 해당 숫자를 left, 끝의 숫자를 right로 하는 재귀 호출
 *          2.1.2 그리고 현재의 left + 1을 left로 그리고 mid - 1을 right로 하는 재귀 호출
 * 		2.2 큰 숫자가 나오지 않으면 현재의 left + 1을 left로 right를 right로 하는 재귀 호출
 * 
 *  4. 짜잔 완성
 *
 */
public class BaekJoon_5639 {
    static int N, pointer;
    static List<Integer> preOrder;
    static int[] postOrder;
    
    static void getPostOrder(int left, int right) {
        if (left > right || pointer < 0) return;
        postOrder[pointer--] = preOrder.get(left);
        
        int mid = -1;
        for (int i=left+1; i<=right; i++) {
            if (preOrder.get(i) > preOrder.get(left)) {
                mid = i;
                break;
            }
        }
        
        if (mid != -1) {
            getPostOrder(mid, right);
            getPostOrder(left + 1, mid - 1);
        } else {
            getPostOrder(left + 1, right);
        }
    }

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String str;
	    
	    preOrder = new ArrayList<>();
	    while ((str = br.readLine()) != null && str.length() > 0) {
	        if (str == null || str.length() == 0) break;
	        preOrder.add(Integer.parseInt(str));
	    }
	    br.close();
	    
	    N = preOrder.size();
	    postOrder = new int[N];
	    
	    pointer = N - 1;
	    getPostOrder(0, N - 1);
	    
	    StringBuilder sb = new StringBuilder();
	    for (int n : postOrder) sb.append(n).append("\n");
	    System.out.print(sb);
	}

}
