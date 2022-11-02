package divideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BaekJoon_2263, 트리순회
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 쓰면서 문제를 푸는 습관을 들여야 할 거 같다.....
 *  2. 지훈이형 풀이 보고 아이디어 겟
 *  
 *
 */
public class BaekJoon_2263 {
    static int N;
    static int[] preOrder, inOrder, postOrder;
    
    static void getPreOrder() {
        
    } 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        
        preOrder = new int[N];
        inOrder = new int[N];
        postOrder = new int[N];
        for (int i=0; i<N; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
            postOrder[i] = Integer.parseInt(st2.nextToken());
        }

        
    }

}
