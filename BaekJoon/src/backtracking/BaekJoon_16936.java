package backtracking;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_16936, 나3곱2
 * 
 * @author PakaOxO
 *  Sketch Idea
 *     1.
 *
 */
public class BaekJoon_16936 {
    static int N;
    static Long max = Long.valueOf("1000000000000000000");
    static Map<Long, Integer> map = new HashMap<>();
    static long[] comb;
    static boolean flag = false;

    static void dfs(long x, int depth) {
        if (flag)
            return;
        if (depth == N) {
            flag = true;
            return;
        }

        if (x % 3 == 0) {
            long next = x / 3;
            if (map.containsKey(next) && map.get(next) > 0) {
                map.put(next, map.get(next) - 1);
                comb[depth] = next;
                dfs(next, depth + 1);
                map.put(next, map.get(next) + 1);
            }
        }
        if (flag)
            return;

        if (x <= max / 2) {
            long next = x * 2;
            if (map.containsKey(next) && map.get(next) > 0) {
                map.put(next, map.get(next) - 1);
                comb[depth] = next;
                dfs(next, depth + 1);
                map.put(next, map.get(next) + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long key = Long.parseLong(st.nextToken());
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        comb = new long[N];
        Set<Long> keySet = map.keySet();
        for (Long key : keySet) {
            comb[0] = key;
            map.put(key, map.get(key) - 1);
            dfs(key, 1);
            map.put(key, map.get(key) + 1);
            if (flag) break;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(comb[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
