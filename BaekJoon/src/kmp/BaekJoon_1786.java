package kmp;

import java.io.*;
import java.util.*;

public class BaekJoon_1786 {
    static String T, P;
    static int[] pi;
    static List<Integer> list = new ArrayList<>();
    
    static void makePi(String str) {
        pi = new int[str.length()];
        int pointer = 0;
        for (int i=1; i<str.length(); i++) {
            while (pointer > 0 && str.charAt(i) != str.charAt(pointer)) {
                pointer = pi[pointer - 1];
            }
            if (str.charAt(i) == str.charAt(pointer)) {
                pi[i] = ++pointer;
            }
        }
    }
    
    static void kmp(String target, String pattern) {
        int pointer = 0;
        for (int i=0; i<target.length(); i++) {
            while (pointer > 0 && target.charAt(i) != pattern.charAt(pointer)) {
                pointer = pi[pointer - 1];
            }
            
            if (target.charAt(i) == pattern.charAt(pointer)) {
                if (pointer == pattern.length() - 1) {
                    list.add(i - (pattern.length() - 1) + 1);
                    pointer = pi[pointer];
                } else
                    pointer++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = br.readLine();
        P = br.readLine();
        
        makePi(P);
        kmp(T, P);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for (int idx : list) sb.append(idx).append(" ");
        System.out.println(sb.toString().trim());
    }

}
