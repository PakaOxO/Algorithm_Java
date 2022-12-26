package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BaekJoon_13241, 최소공배수
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_13241 {
    static int getLCM(int a, int b) {
        if (b == 0) return a;
        return getLCM(b, a % b);
    }
    
    static long getGCD(int a, int b) {
        return (long)a * b / getLCM(a, b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        System.out.println(getGCD(A, B));
    }

}
