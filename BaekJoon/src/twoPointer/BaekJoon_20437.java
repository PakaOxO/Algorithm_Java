package twoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * BaekJoon_20437, 문자열 게임 2
 *  - 문제 분류 : 문자열, 슬라이딩 윈도우
 */
public class BaekJoon_20437 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        Solution_문자열게임2 s = new Solution_문자열게임2();
        
        for (int tc=0; tc<T; tc++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            
            sb.append(s.solution(W, K)).append("\n");
        }
        
        System.out.println(sb.toString().trim());
    }
}

class Solution_문자열게임2 {
    
    String solution(String str, int k) {
        /* 변수 초기화 */
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        int minLen = len + 1;
        int maxLen = 0;
        List<Integer>[] pos = new ArrayList[26];
        
        /* 메인 로직 */
        for (int i=0; i<len; i++) {
            char c = str.charAt(i);
            int idx = (int)(c - 'a');
            if (pos[idx] == null) {
                pos[idx] = new ArrayList<Integer>();
            }
            
            pos[idx].add(i);
            
            if (pos[idx].size() >= k) {
                int back = pos[idx].size() - 1;
                minLen = Math.min(minLen, pos[idx].get(back) - pos[idx].get(back - k + 1) + 1);
                maxLen = Math.max(maxLen,  pos[idx].get(back) - pos[idx].get(back - k + 1) + 1);
            }
        }
        
        if (minLen > len) {
            sb.append(-1);
        } else {
            sb.append(minLen).append(" ").append(maxLen);
        }
        
        /* 결과 반환 */
        return sb.toString();
    }
}