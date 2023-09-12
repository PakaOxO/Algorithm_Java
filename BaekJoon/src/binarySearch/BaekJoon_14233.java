package binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BaekJoon_14233, 악덕 사장
 *  - 문제 분류 : 이분 탐색, 그리디
 */
public class BaekJoon_14233 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Solution_악덕사장 s = new Solution_악덕사장();
        System.out.println(s.solution(N, arr));
    }

}

class Solution_악덕사장 {
    static int INF = 1000000000;
    int N;
    int[] arr;
    int answer = INF;
    
    int solution(int N, int[] arr) {
        this.N = N;
        this.arr = arr;
        
        Arrays.sort(this.arr);
        
        for (int i=0; i<N; i++) {
            answer = Math.min(answer, arr[i] / (i + 1));
        }
        
        return answer;
    }
}