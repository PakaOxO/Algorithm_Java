package acc;

import java.io.*;
import java.util.*;

public class BaekJoon_4821 {
    static int MAX;
    static int[] pages;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = null;
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            MAX = Integer.parseInt(br.readLine());
            if (MAX == 0) break;
            
            arr = br.readLine().split(",");
            pages = new int[MAX + 2];
            answer = 0;
            
            for (int i=0; i<arr.length; i++) {
                String[] range = arr[i].split("-");
                int from = Integer.parseInt(range[0]);
                int to = range.length == 1 ? from : Integer.parseInt(range[1]);
                if (from > to || from > MAX) continue;
                
                pages[from]++;
                pages[to > MAX ? MAX + 1 : to + 1]--;
            }
            
            for (int i=1; i<MAX+1; i++) {
                pages[i] += pages[i - 1];
                if (pages[i] > 0) answer++;
            }
            
            sb.append(answer).append("\n");
        }
        
        System.out.println(sb.toString().trim());
    }

}
