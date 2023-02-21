package dp;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_23057, 도전 숫자왕 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_23057 {
    static int N, answer;
    static int[] card;
    static Set<Integer> set = new HashSet<>();
    
    static void dfs(int depth, int sum) {
        set.add(sum);
        if (depth == N) return;
        
        dfs(depth + 1, sum);
        dfs(depth + 1, sum + card[depth]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        card = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
            answer += card[i];
        }
        br.close();
        
        dfs(0, 0);
        answer -= set.size();
        System.out.println(++answer);
    }

}
