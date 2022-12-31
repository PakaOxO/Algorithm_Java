package math;

import java.io.*;

/**
 * BaekJoon_10859, 뒤집혀진 소수 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_10859 {
    static int INF = 100000000;
    static int[] reversed = { 0, 1, 2, -1, -1, 5, 9, -1, 8, 6 };
    static boolean[] isNotPrime;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        
        boolean flag = false;
        long reversedN = 0;
        for (int i=N.length()-1; i>=0; i--) {
            int num = reversed[(int)(N.charAt(i) - '0')];
            if (num < 0) {
                flag = true;
                reversedN = -1;
                break;
            }
            reversedN = reversedN * 10 + num;
        }
        
        if (reversedN != -1) {
            if (Long.parseLong(N) > INF || reversedN > INF) {
                for (int i=2; i<=INF; i++) {
                    if (Long.parseLong(N) % i == 0 || reversedN % i == 0) {
                        flag = true;
                        break;
                    }
                }
            } else {
                isNotPrime = new boolean[INF + 1];
                isNotPrime[1] = true;
                for (int i=2; i*i<=INF; i++) {
                    if (isNotPrime[i]) continue;
                    for (int j=i*i; j<=INF; j+=i) {
                        isNotPrime[j] = true;
                    }
                }
                if (isNotPrime[Integer.parseInt(N)] || isNotPrime[(int)reversedN]) {
                    flag = true;
                }
            }
        }
        if (flag) {
            System.out.println("no");
        } else {
            System.out.println("yes");
        }
    }

}
