package binarySearch;

import java.io.*;

public class BaekJoon_14246 {
    static int N, K;
    static long answer;
    static long[] acc;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        acc = new long[N + 1];
        
        String[] input = br.readLine().split(" ");
        for (int i=1; i<=N; i++) {
            acc[i] += Integer.parseInt(input[i - 1]);
            acc[i] += acc[i - 1];
        }
        
        K = Integer.parseInt(br.readLine());
        
        for (int i=1; i<=N; i++) {
            int left = i;
            int right = N;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (acc[mid] - acc[i - 1] <= K) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            
            if (left > N) break;
            answer += N - left + 1;
        }
        
        System.out.println(answer);
    }

}
