package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BaekJoon_14003, 가장 긴 증가하는 부분 수열 5
 * @author arpeg
 *
 */
public class BaekJoon_14003 {
    static int N;
    static int[] arr, dpCnt;
    static StringBuilder[] dpList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        arr[0] = Integer.MIN_VALUE;
        
        dpCnt = new int[N + 1];
        dpList = new StringBuilder[N + 1];
        dpList[0] = new StringBuilder();
        
        int answerIdx = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            int maxIdx = 0;
            int left = 0;
            int right = i;
            while (left < right) {
                int mid = (left + right) / 2;
            }
            
            
            for (int j=0; j<i; j++) {
                if (arr[i] > arr[j] && dpCnt[j] > dpCnt[maxIdx]) {
                    maxIdx = j;
                }
            }
            dpCnt[i] = dpCnt[maxIdx] + 1;
            
            if (dpCnt[i] > 1) dpList[i] = new StringBuilder(dpList[maxIdx].toString()).append(" ").append(arr[i]);
            else dpList[i] = new StringBuilder().append(arr[i]);
            
            if (dpCnt[i] > dpCnt[answerIdx]) answerIdx = i;
        }
        
        StringBuilder answer = new StringBuilder();
        answer.append(dpCnt[answerIdx]).append("\n").append(dpList[answerIdx]);
        
        System.out.println(answer);
    }

}
