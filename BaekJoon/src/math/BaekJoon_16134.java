package math;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_16134, 조합(Combination)
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 페르마의 소정리
 *
 */
public class BaekJoon_16134 {

	static int modular = 1000000007;
    
    static long exp(long a, int b) {
        if (b == 0) return 1;
         
        long c = exp(a, b / 2);
        if (c > modular) c = getMod(c);
        if (b % 2 == 0) return getMod(c * c);
        else return getMod(getMod(c * c) * a);
    }
     
     
    static long factorial(int n) {
        if (n == 0) return 1;
         
        long result = 1;
        while (n > 0) {
            result *= n;
            if (result > modular) result = getMod(result);
            n--;
        }
        return result;
    }
     
    static long getMod(long n) {
        if (n < modular) return n;
        else return n % modular;
    }
     
    static long getComb(int n, int r) {
        if (n == r || r == 0) return 1;
        if (r == 1) return n;
         
        return getMod(factorial(n) * exp(getMod(factorial(n - r) * factorial(r)), modular - 2));
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        System.out.print(getComb(N, R));
        br.close();
    }

}
