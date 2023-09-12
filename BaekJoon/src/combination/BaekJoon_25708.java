package combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BaekJoon_25708, 만남의 광장
 *  - 문제 분류 : 조합, 완전 탐색
 */

public class BaekJoon_25708 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        Solution_만남의광장 s = new Solution_만남의광장();
        System.out.println(s.solution(N, M, map));
    }

}

class Solution_만남의광장 {
    int N, M;
    int[][] map;
    int[] comb;
    int[] rowSum, colSum;
    int answer;
    
    public int solution(int n, int m, int[][] map) {
        /* 변수 초기화 */
        this.N = n;
        this.M = m;
        this.map = map;
        this.rowSum = new int[n];
        this.colSum = new int[m];
        
        answer = Integer.MIN_VALUE;
        
        /* 메인 로직 */
        getRowSum();
        getColSum();
        
        for (int i=0; i<N; i++) {
            for (int j=i+1; j<N; j++) {
                for (int k=0; k<M; k++) {
                    for (int l=k+1; l<M; l++) {
                        int total = rowSum[i] + rowSum[j] + colSum[k] + colSum[l] - map[i][k] - map[i][l] - map[j][k] - map[j][l] + ((j - i - 1) * (l - k - 1));
                        answer = Math.max(answer, total);
                    }
                }
            }
        }
        
        /* 정답 반환 */
        return answer;
    }
    
    /**
     * 각 행의 누적합 계싼
     */
    void getRowSum() {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                rowSum[i] += map[i][j];
            }
        }
    }
    
    /**
     * 각 열의 누적합 계산
     */
    void getColSum() {
        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                colSum[i] += map[j][i];
            }
        }
    }
}