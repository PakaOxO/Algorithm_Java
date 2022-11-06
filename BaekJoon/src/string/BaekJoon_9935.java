package string;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_9935, 문자열 폭발
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 일단 전체 문자열을 rq에 넣음
 *  2. rq가 빌때까지 루프를 돌면서 문자열 체크
 *      2.1 다음 rq에서 뺄 문자가 bomb[pointer] 문자와 같으면 lq에 넣으면서 pointer + 1
 *      2.2 다르면 
 *
 */
public class BaekJoon_9935 {
    static int len, pointer;
    static char[] bomb;
    static Deque<Character> lq, rq;
    
    static void play() {
        while (!rq.isEmpty()) {
            if (rq.peekFirst() == bomb[pointer]) {
                lq.addLast(rq.pollFirst());
                pointer++;
                if (pointer == bomb.length) { 
                    while (pointer > 0) {
                        pointer--;
                        lq.pollLast();
                    }
                    for (int i=0; i<bomb.length-1; i++) {
                        if (lq.isEmpty()) break;
                        rq.addFirst(lq.pollLast());
                    }
                }
                continue;
            }
            
            lq.addLast(rq.pollFirst());
            if (lq.peekLast() == bomb[0]) pointer = 1;
            else pointer = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        bomb = br.readLine().toCharArray();
        br.close();
        
        len = input.length();
        lq = new ArrayDeque<>();
        rq = new ArrayDeque<>();
        for (int i=0; i<len; i++) {
            rq.addLast(input.charAt(i));
        }
        
        play();
        StringBuilder sb = new StringBuilder();
        if (lq.size() > 0) {
            while (!lq.isEmpty()) {
                sb.append(lq.pollFirst());
            }
        } else {
            sb.append("FRULA");
        }
        System.out.println(sb);
    }

}
