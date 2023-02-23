package greedy;

import java.io.*;
import java.math.*;
import java.util.*;

/**
 * BaekJoon_20915, 숫자 카드 놀이 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_20915 {
    static int N, len, zeroCnt;
    static Integer[] cards;
    static long answer;
    
    static void dfs(int depth, int idx, long comb1, long comb2) {
        if (depth == len - zeroCnt || cards[idx] == '0') {
            long calc = comb1 * comb2;
            if (calc > answer) {
                answer = calc;
            }
            return;
        }
        
        dfs(depth + 1, idx + 1, comb1 * 10 + cards[idx], comb2);
        dfs(depth + 1, idx + 1, comb1, comb2 * 10 + cards[idx]); 
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            String input = br.readLine();
            len = input.length();
            cards = new Integer[len];
            
            zeroCnt = 0;
            for (int j=0; j<len; j++) {
                cards[j] = (int)(input.charAt(j) - '0');
                if (cards[j] == 6) cards[j] = 9;
                else if (cards[j] == 0) zeroCnt++;
            }
            Arrays.sort(cards, Collections.reverseOrder());
            
            answer = 0;
            dfs(0, 0, 0, 0);
            
            if (answer == 0) {
                sb.append(answer).append("\n");
            } else {
                sb.append(answer).append("0".repeat(zeroCnt)).append("\n");
            }
        }
        br.close();
        System.out.println(sb.toString().trim());
    }

}
