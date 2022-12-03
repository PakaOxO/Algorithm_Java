package disjointSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BaekJoon_9372, 상근이의 여행 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. disjoint set을 활용한 mst 계산 
 *
 */
public class BaekJoon_9372 {
    static int N, M, cnt;
    static int[] p;
    
    static void initParent() {
        p = new int[N + 1];
        for (int i=1; i<=N; i++) {
            p[i] = i;
        }
    }
    
    static int findSet(int x) {
        if (p[x] != x) p[x] = findSet(p[x]);
        return p[x];
    }
    
    static boolean union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);
        if (px == py) return false;
        
        p[py] = px;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int tc=0; tc<T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            cnt = 0;
            
            initParent();
            for (int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                
                boolean flag = union(x, y);
                if (flag) cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

}
