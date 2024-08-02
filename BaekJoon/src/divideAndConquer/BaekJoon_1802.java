package divideAndConquer;

import java.io.*;
import java.util.*;

public class BaekJoon_1802 {
    private static int N;
    
    private static boolean check(String str) {
        int center = str.length() / 2;
        if (center == 0) return true;
        
        for (int i=1; i<=center; i++) {
            if (str.charAt(center - i) == str.charAt(center + i)) return false;
        }
        
        return check(str.substring(0, center)) && check(str.substring(center + 1));
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<N; i++) {
            sb.append(check(br.readLine()) ? "YES\n" : "NO\n");
        }
        
        System.out.println(sb.toString().trim());
    }

}
