package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BaekJoon_11663, 선분 위의 점
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_11663 {
    static int N, M;
    static int[] points;
    
    static int findLeft(int p) {
        if (points[0] > p) return 0;
        
        int left = 0;
        int right = N - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (points[mid] >= p) {
                if (points[mid] == p) return mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    static int findRight(int p) {
        if (points[N - 1] < p) return N;
        
        int left = 0;
        int right = N - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (points[mid] >= p) {
                if (points[mid] == p) return mid + 1;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right + 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        points = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(points);
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            
            sb.append(findRight(right) - findLeft(left)).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

}
