package sort;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2696, 중앙값 구하기 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_2696 {
    static int T, N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        
        for (int tc=0; tc<T; tc++) {
            N = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();
            int cnt = 0;
            int res = N;
            StringBuilder sb2 = new StringBuilder();
            while (res > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                if (res > 9) {
                    for (int j=0; j<10; j++) {
                        list.add(Integer.parseInt(st.nextToken()));
                        if (j % 2 == 0) {
                            Collections.sort(list);
                            sb2.append(list.get(list.size() / 2)).append(" ");
                            cnt++;
                            if (cnt == 10) sb2.append("\n");
                        }
                    }
                    res -= 10;
                } else {
                    for (int j=0; j<res; j++) {
                        list.add(Integer.parseInt(st.nextToken()));
                        if (j % 2 == 0) {
                            Collections.sort(list);
                            sb2.append(list.get(list.size() / 2)).append(" ");
                            cnt++;
                            if (cnt == 10) sb2.append("\n");
                        }
                    }
                    res = 0;
                }
            }
            sb.append(cnt).append("\n").append(sb2.toString()).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

}
