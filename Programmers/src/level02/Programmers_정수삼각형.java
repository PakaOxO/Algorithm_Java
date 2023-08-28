package level02;

public class Programmers_정수삼각형 {
    public static void main(String[] args) {
    	Solution_정수삼각형 s = new Solution_정수삼각형();
        System.out.println(s.solution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
}

class Solution_정수삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;
        int N = triangle.length;
        int[][] dp = new int[N][];
        for (int i=0; i<N; i++) {
            dp[i] = new int[i + 1];
        }

        for (int i=N-1; i>=0; i--) {
            for (int j=0; j<=i; j++) {
                if (i == N - 1) {
                    dp[i][j] = triangle[i][j];
                    continue;
                }
                dp[i][j] = triangle[i][j] + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        return dp[0][0];
    }
}