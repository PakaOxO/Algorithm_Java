package implementation;

import java.io.*;
import java.util.*;

public class BaekJoon_16960 {
    static int N, M;
    static List<Integer>[] sw;
    static int[] cnt;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        sw = new ArrayList[N + 1];
        cnt = new int[M + 1];

        for (int i=1; i<=N; i++) {
            sw[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int lCnt = Integer.parseInt(st.nextToken());
            for (int j=0; j<lCnt; j++) {
                int lamp = Integer.parseInt(st.nextToken());
                sw[i].add(lamp);
                cnt[lamp]++;
            }
        }
        
        boolean flag = false;
        for (int i=1; i<=N; i++) {
            boolean flag2 = true;
            for (int lamp : sw[i]) {
                if (cnt[lamp] < 2) flag2 = false;
            }
            if (flag2) {
                flag = true;
                break;
            }
        }
        
        if (flag) System.out.println(1);
        else System.out.println(0);
    }

}
