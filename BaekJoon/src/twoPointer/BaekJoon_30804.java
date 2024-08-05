package twoPointer;

import java.io.*;
import java.util.*;

public class BaekJoon_30804 {
    static int N;
    static int[] tang;
    static int[] count = new int[10];
    static int answer = 0;
    
    static boolean check() {
        int c = 0;
        for (int i=1; i<=9; i++) {
            if (count[i] > 0) c++;
            if (c > 2) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tang = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i=0; i<N; i++) {
            tang[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int right = 0;
        
        while (right < N) {
            count[tang[right]]++;
            while (!check()) {
                count[tang[left++]]--;
            }
            
            answer = Math.max(answer, right - left + 1);
            right++;
        }
        
        System.out.println(answer);
    }

}
