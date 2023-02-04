package BaekJoon_AnimeCup2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BaekJoon_AnimeCup_01, :chino_shock:
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_AnimeCup_01 {
    static int answer = 7;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().substring(6);
        
        int len = input.length();
        answer += len;
        for (int i=0; i<len; i++) {
            char c = input.charAt(i);
            if (c == '_') {
                answer += 5;
            } else if (c == ':'){
                answer++;
            }
        }
        System.out.println(answer);
    }

}
