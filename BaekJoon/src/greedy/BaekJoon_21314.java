package greedy;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_21314, 민겸수 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 주어진 입력을 뒤에서부터 탐색 
 *  2. 제일 작은 수는
 *      2.1 K는 바로 5로 M은 이어져 있는 대로 바로 숫자로 (M = 1, MM = 10, MMM = 100 ...)
 *  3. 제일 큰 수는
 *      3.1 K 앞에 M이 있다면 K가 나올 때까지 계속 0을 붙여가며 5, 50, 500..으로 만들어 다시 스택에 담음
 *      3.2 M은 2.1에 의해 앞에 K가 스택에 있었다면 위 과정으로 빠져나가거나 M 홀로 입력값에서 가져오는 경우 둘로 나뉨. 그냥 입력값에서 가져올 땐 1을 스택에 넣음
 *  4. 구한 최대, 최소 숫자를 출력 
 *
 */
public class BaekJoon_21314 {
    static Stack<String> stack = new Stack<>();
    
    static String getMax(String input) {
        int idx = input.length()-1;
        char c = input.charAt(idx--);
        
        if (c == 'K') stack.push("5");
        else stack.push("1");
        
        while (idx >= 0) {
            c = input.charAt(idx--);
            if (c == 'K') stack.push("5");
            else {
                if (stack.peek().equals("1")) {
                    stack.push("1");
                } else {
                    stack.push(stack.pop() + "0");
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    
    static String getMin(String input) {
        int idx = input.length()-1;
        char c = input.charAt(idx--);
        
        if (c == 'K') stack.push("5");
        else stack.push("1");
        
        while (idx >= 0) {
            c = input.charAt(idx--);
            if (c == 'K') stack.push("5");
            else {
                if (stack.peek().equals("5")) {
                    stack.push("1");
                } else {
                    stack.push(stack.pop() + "0");
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.println(getMax(input));
        System.out.println(getMin(input));
    }

}
