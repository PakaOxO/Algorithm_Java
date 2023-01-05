package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1034, 램프
 * 
 * @author kevin-Arpe
 * 
 *         Sketch Idea
 *         1.
 *
 */
public class BaekJoon_1034 {
    static int N, M, K, answer;
    static String[] lamp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        lamp = new String[N];
        for (int i=0; i<N; i++) {
            lamp[i] = br.readLine();
        }
        
        K = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<N; i++) {
            int cnt = 0;
            for (int j=0; j<M; j++) {
                if (lamp[i].charAt(j) == '0') cnt++;
            }
            if (cnt > K || cnt % 2 != K % 2) continue;
            // 해당 행의 off 개수가 K보다 크면 해당 행은 모두 켤 수 없고,
            // 행을 켜기 위해 필요한 스위치 개수와 남은 K의 개수의 차이가 홀수면 해당 행을 ON으로 만들 수 없으므로 pass 
            
            String key = lamp[i];
            if (!map.containsKey(key))
                map.put(key, 1);
            else
                map.put(key, map.get(key) + 1);
            answer = Math.max(answer, map.get(key));
        }
        System.out.println(answer);
    }
}
