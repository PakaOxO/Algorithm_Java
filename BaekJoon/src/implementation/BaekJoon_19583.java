package implementation;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_19583, 싸이버개강총회
 * @author PakaOxO
 * 
 * Sketch Idea
 *  1. 시간 비교 문제인듯
 *
 */
public class BaekJoon_19583 {
    static String S, E, Q;
    static Map<String, Boolean[]> students = new HashMap<>();
    
    static boolean isAfter(String t1, String t2) {
        int[] time1 = Arrays.stream(t1.split(":")).mapToInt(Integer::parseInt).toArray();
        int[] time2 = Arrays.stream(t2.split(":")).mapToInt(Integer::parseInt).toArray();
        
        if (time2[0] > time1[0]) return true;
        if (time2[0] == time1[0] && time2[1] >= time1[1]) return true;
        return false;
    }
    
    static boolean isBefore(String t1, String t2) {
        int[] time1 = Arrays.stream(t1.split(":")).mapToInt(Integer::parseInt).toArray();
        int[] time2 = Arrays.stream(t2.split(":")).mapToInt(Integer::parseInt).toArray();
        
        if (time2[0] < time1[0]) return true;
        if (time2[0] == time1[0] && time2[1] <= time1[1]) return true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = st.nextToken(); E = st.nextToken(); Q = st.nextToken();
        
        String input;
        int answer = 0;
        while (true) {
            input = br.readLine();
            if (input == null || input.length() == 0) break;
            String[] str = input.split(" ");
            
            if (!students.containsKey(str[1])) {
                if (isBefore(S, str[0])) {
                    students.put(str[1], new Boolean[] { true, false });
                } else {
                    students.put(str[1], new Boolean[] { false, false });
                }
            } else {
                if (isAfter(E, str[0]) && isBefore(Q, str[0]) && students.get(str[1])[0]) {
                    if (students.get(str[1])[1]) continue;
                    answer++;
                    students.put(str[1], new Boolean[] { true, true });
                }
            }
        }
        System.out.println(answer);
    }

}
