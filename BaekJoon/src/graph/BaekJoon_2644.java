package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon_2644 {
    static int N, M, A, B;
    static List<Integer>[] list = null;
    static boolean[] v = null;
    static boolean flag = false;
    static int answer = -1;
    
    static void dfs(int pos, int depth) {
        if (pos == B) {
            flag = true;
            answer = depth;
        }
        if (flag) return;
        
        for (int next : list[pos]) {
            if (v[next]) continue;
            v[next] = true;
            dfs(next, depth + 1);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken()) - 1;
        B = Integer.parseInt(st.nextToken()) - 1;
        M = Integer.parseInt(br.readLine());
        
        list = new ArrayList[N];
        v = new boolean[N];
        
        for (int i=0; i<N; i++) list[i] = new ArrayList<Integer>();
        
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken()) - 1;
            int child = Integer.parseInt(st.nextToken()) - 1;
            
            list[parent].add(child);
            list[child].add(parent);
        }
        
        v[A] = true;
        dfs(A, 0);
        
        System.out.println(answer);
    }
}
