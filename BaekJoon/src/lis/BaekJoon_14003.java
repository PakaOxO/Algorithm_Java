package lis;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_14003, 가장 긴 증가하는 부분 수열 5
 * @author arpeg
 *
 */
public class BaekJoon_14003 {
    static int N;
    static int[] dp, arr;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        arr = new int[N];
        
        int maxIdx = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        loop:
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (list.isEmpty()) {
                list.add(arr[i]);
                dp[i] = 1;
            }
            else {
                if (arr[i] > list.get(list.size() - 1)) {
                    list.add(arr[i]);
                    dp[i] = list.size();
                } else {
                    int left = 0;
                    int right = list.size();
                    int mid = -1;
                    while (left <= right) {
                        mid = (left + right) / 2;
                        if (left == right) break;
                        
                        if (arr[i] >= list.get(mid)) {
                            if (arr[i] == list.get(mid)) continue loop;
                            left = mid + 1;
                        } else {
                            right = mid;
                        }
                    }
                    list.set(mid, arr[i]);
                    dp[i] = mid + 1;
                }
            }
            
            if (dp[i] > dp[maxIdx]) maxIdx = i;
        }
        
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[maxIdx]);
        for (int i=maxIdx-1; i>=0; i--) {
            if (dp[maxIdx] - dp[i] == 1 && arr[maxIdx] > arr[i]) {
                stack.push(arr[i]);
                maxIdx = i;
            }
        }
        
        StringBuilder sb = new StringBuilder().append(stack.size()).append("\n");
        StringBuilder sb2 = new StringBuilder();
        while (!stack.isEmpty()) {
            sb2.append(" ").append(stack.pop());
        }
        sb.append(sb2.toString().trim());
        System.out.println(sb);
    }

}
