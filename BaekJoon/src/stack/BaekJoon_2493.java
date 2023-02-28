package stack;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2493, 탑 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_2493 {
    static int N, max;
    static Stack<int[]> stack = new Stack<>();
    static int[] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = new int[N + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        
        for (int i=1; i<=N; i++) {
            int curr = Integer.parseInt(st.nextToken());
            if (stack.isEmpty()) {
                answer[i] = 0;
            } else {
                while (!stack.isEmpty()) {
                    int[] top = stack.peek();
                    if (top[1] > curr) {
                        answer[i] = top[0];
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            stack.push(new int[] { i, curr });
        }
        
        
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

}
