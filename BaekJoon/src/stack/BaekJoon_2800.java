package stack;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2800, 괄호 제거
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 올바른 괄호 체크에 대해 제대로 이해하지 못했던 문제
 *  2. 괄호 유효성 체크를 stack을 사용하지 않고 해결해보려고 시도했으나 
 *      2.1 짝이 되는 닫는 괄호를 뒤에서부터 찾았음 -> 틀림
 *      2.2 여는 괄호의 번째수와 같은 번째수(닫는괄호 중에서)의 닫는 괄호 선택 -> 틀림
 *  
 *  3. 결국 Stack을 쓰고 풀었음
 *
 */
public class BaekJoon_2800 {
    static int len;
    static Set<String> answer;
    static List<int[]> arr;
    static boolean[] isRemoved;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();
        
        len = input.length();
        arr = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<len; i++) {
            if (input.charAt(i) == '(') {
                stack.push(i);
            } else if (input.charAt(i) == ')') {
                arr.add(new int[] { stack.pop(), i });
            }
        }
        
        isRemoved = new boolean[len];
        answer = new TreeSet<>();
        
        int arrLen = arr.size();
        for (int i=1; i<(1 << arrLen); i++) {
            for (int j=0; j<arrLen; j++) {
                if ((i & (1 << j)) > 0) {
                    isRemoved[arr.get(j)[0]] = true;
                    isRemoved[arr.get(j)[1]] = true;
                }
            }
            
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<len; j++) {
                if (isRemoved[j]) continue;
                sb.append(input.charAt(j));
            }
            answer.add(sb.toString());
            
            for (int j=0; j<arrLen; j++) {
                isRemoved[arr.get(j)[0]] = false;
                isRemoved[arr.get(j)[1]] = false;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (String str : answer) {
            sb.append(str).append("\n");
        }
        System.out.print(sb);
    }

}
