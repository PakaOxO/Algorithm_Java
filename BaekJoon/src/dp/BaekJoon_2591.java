package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BaekJoon_2591, 숫자카드 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 완전 탐색으로 풀이 (dp 풀이도 있음) 
 *
 */
public class BaekJoon_2591 {
    static String input;
    static int len;
    static long answer;
    
    static void dfs(int idx) {
        if (idx >= len) {
            answer++;
            return;
        }
        
        int num = input.charAt(idx) - '0';
        if (num == 0) return;
        
        if (idx < len - 1) {
            if (num <= 3) {
                int next = input.charAt(idx + 1) - '0';
                if (num < 3 || next <= 4)
                    dfs(idx + 2);
                if (next > 0)
                    dfs(idx + 1);
                
            } else
                dfs(idx + 1);
                
        } else
            dfs(idx + 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        input = br.readLine();
        len = input.length();
        
        dfs(0);
        System.out.println(answer);
    }

}
