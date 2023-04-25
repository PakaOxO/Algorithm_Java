package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BaekJoon_1411, 비슷한 단어
 * @author PakaOxO
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_1411 {
    static int N, len;
    static String[] words;
    static int[] group;
    
    static boolean isSimilar(String w1, String w2) {
        char[] arr1 = new char[26];
        char[] arr2 = new char[26];
        
        for (int i=0; i<len; i++) {
            char c1 = w1.charAt(i);
            char c2 = w2.charAt(i);
            if (arr1[(int)(c1 - 'a')] >= 'a' || arr2[(int)(c2 - 'a')] >= 'a') {
                if (arr1[(int)(c1 - 'a')] != c2) {
                    return false;
                }
            } else {
                arr1[(int)(c1 - 'a')] = c2;
                arr2[(int)(c2 - 'a')] = c1;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        words = new String[N + 1];
        group = new int[N + 1];
        for (int i=1; i<=N; i++) words[i] = br.readLine();
        
        len = words[1].length();
        int answer = 0;
        for (int i=1; i<=N; i++) {
            for (int j=i+1; j<=N; j++) {
                if (isSimilar(words[i], words[j])) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

}
