package lis;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_14002, 가장 긴 증가하는 부분 수열 4
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_14002 {
    static int N, numSize, dpMax;
    static int[] arr, nums, dp;
    
    static int binarySearch(int target, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (target >= nums[mid]) {
                if (target == nums[mid]) return mid;
                left = mid + 1;
            } else
                right = mid;
        }
        return left;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N];
        nums = new int[N];
        dp = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (numSize == 0) {
                nums[numSize++] = arr[i];
                dp[i] = numSize;
                if (dp[i] > dp[dpMax]) dpMax = i;
                continue;
            }
            if (arr[i] > nums[numSize - 1]) {
                nums[numSize++] = arr[i];
                dp[i] = numSize;
                if (dp[i] > dp[dpMax]) dpMax = i;
                continue;
            }
            
            int idx = binarySearch(arr[i], 0, numSize);
            nums[idx] = arr[i];
            dp[i] = idx + 1;
            if (dp[i] > dp[dpMax]) dpMax = i;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(dp[dpMax]).append("\n");
        
        Stack<Integer> s = new Stack<>();
        s.push(arr[dpMax]);
        for (int i=dpMax-1; i>=0; i--) {
            if (dp[dpMax] - dp[i] == 1 && arr[i] < arr[dpMax]) {
                s.push(arr[i]);
                dpMax = i;
            }
        }
        
        StringBuilder list = new StringBuilder();
        while (!s.isEmpty()) {
            list.append(s.pop()).append(" ");
        }
        
        sb.append(list.toString().trim());
        System.out.println(sb);
    }

}
