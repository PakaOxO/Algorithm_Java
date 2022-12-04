package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BaekJoon_5347, LCM 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_5347 {
    static int getGCD(int a, int b) {
        if (b == 0) return a;
        
        return getGCD(b, a % b);
    }
    
    static long getLCM(int a, int b) {
        return (long)a * b / getGCD(a, b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int tc=0; tc<T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(getLCM(a, b)).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

}
