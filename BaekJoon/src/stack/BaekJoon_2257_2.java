package stack;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2257, 화학식량 (재풀이) 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_2257_2 {
    static Map<Character, Integer> mWeight = new HashMap<>();
    static Stack<Character>lStack, rStack;
    static Map<Character, Integer> cnt = new HashMap<>();
    static int[] total = new int[3];
    
    static boolean topIsAtom() {
        if (lStack.peek() == 'C' || lStack.peek() == 'O' || lStack.peek() == 'H') return true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        mWeight.put('C', 12);
        mWeight.put('O', 16);
        mWeight.put('H', 1);
        
        lStack = new Stack<>();
        rStack = new Stack<>();
        
        String line = br.readLine();
        for (int i=0; i<line.length(); i++) {
            char c = line.charAt(i);
            if (c == '(') {
                lStack.push(c);
            } else if (c == ')') {
                int cnt = 1;
                if (i < line.length() - 1) {
                    if (line.charAt(i + 1) >= '1' && line.charAt(i + 1) <= '9') {
                        cnt = (int)(line.charAt(i + 1) - '0');
                        i++;
                    }
                }
                while (lStack.peek() != '(') {
                    for (int j=0; j<cnt; j++) {
                        rStack.push(lStack.peek());
                    }
                    lStack.pop();
                }
                lStack.pop();
            } else if (c == 'C' || c == 'O' || c == 'H') {
                lStack.push(c);
            } else {
                int cnt = (int)(c - '0');
                for (int j=1; j<cnt; j++)
                    lStack.push(lStack.peek());
            }
            
            while (rStack.size() > 0) {
                lStack.push(rStack.pop());
            }
        }
        
        int answer = 0;
        while (!lStack.isEmpty()) {
            answer += mWeight.get(lStack.pop());
        }
        System.out.println(answer);
    }

}
