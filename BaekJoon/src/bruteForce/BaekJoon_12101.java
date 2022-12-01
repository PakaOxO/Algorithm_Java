package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_12101, 1,2,3 더하기 2
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 숫자 N을 만들 수 있는 모든 가지 수를 dfs로 오름차순 계산식을 구하면서 k번째 식이 나오면 해당 식을 도출
 *
 */
public class BaekJoon_12101 {
    static int N, K, cnt;
    static boolean flag;
    static StringBuilder answer = new StringBuilder();
    
    static void dfs(int sum, List<Integer> list) {
        if (sum > N) return;
        if (sum == N) {
            cnt++;
            if (cnt == K) {
                for (int i=0; i<list.size(); i++) {
                    if (i < list.size() - 1) {
                        answer.append(String.valueOf(list.get(i))).append("+");                        
                    } else {
                        answer.append(String.valueOf(list.get(i)));
                    }
                }
                flag = true;                
            }
            return;
        }
        
        for (int i=1; i<=3; i++) {
            if (flag) return;
            list.add(i);
            dfs(sum + i, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        cnt = 0;
        dfs(0, new ArrayList<>());
        
        if (answer.toString().length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

}
