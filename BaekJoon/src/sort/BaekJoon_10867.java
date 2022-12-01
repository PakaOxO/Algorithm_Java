package sort;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_10867, 중복 빼고 정렬하기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_10867 {
    static boolean[] hasNum = new boolean[2001];
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (hasNum[num + 1000]) continue;
            hasNum[num + 1000] = true;
            list.add(num);
        }
        
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

}
