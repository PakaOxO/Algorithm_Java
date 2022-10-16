package implementation;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_12933, 오리
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 오리가 울면 무조건 quack이란 단어가 완성이 되어야 하므로 q가 1개 있으면 나머지 글자도 1개 있어야 함
 *  2. 해당 이유로 q 1개에 나머지 글자들도 제거하는 과정 사용
 *
 */
public class BaekJoon_12933 {
    static int answer;
    static int[] letterCnt;
    
    static boolean addLetter(char c) {
        if (c == 'q') {
            letterCnt[0]++;
            answer = Math.max(answer, letterCnt[0] - letterCnt[4]);
        }
        else if (c == 'u') {
            letterCnt[1]++;
            if (letterCnt[1] > letterCnt[0]) return false;
        }
        else if (c == 'a') {
            letterCnt[2]++;
            if (letterCnt[2] > letterCnt[1] || letterCnt[2] > letterCnt[0]) return false;
        }
        else if (c == 'c') {
            letterCnt[3]++;
            if (letterCnt[3] > letterCnt[2] || letterCnt[3] > letterCnt[1] || letterCnt[3] > letterCnt[0]) return false;
        }
        else if (c == 'k') {
            letterCnt[4]++;
            if (letterCnt[4] > letterCnt[3] || letterCnt[4] > letterCnt[2] || letterCnt[4] > letterCnt[1] || letterCnt[4] > letterCnt[0]) return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int len = input.length();
        
        letterCnt = new int[5];
        answer = 0;
        for (int i=0; i<len; i++) {
            char c = input.charAt(i);
            boolean flag = addLetter(c);
            if (!flag) {
                answer = -1;
                break;
            }
        }
        
        if (!(letterCnt[0] == letterCnt[1] && letterCnt[1] == letterCnt[2] && letterCnt[2] == letterCnt[3] && letterCnt[3] == letterCnt[4])) answer = -1;
        System.out.println(answer);
    }

}
