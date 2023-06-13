package level03;

public class Programmers_등굣길 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(4, 3, new int[][] { { 2, 2 } }));
	}

}

class Solution {
	public static boolean[][] isPuddles;
	public static long[][] dp;
	public static int INF = 1000000007;
	
	public static long dp(int r, int c) {
		if (r * c == 0 || isPuddles[r][c]) return 0;
		if (r * c == 1) return 1;
		if (dp[r][c] > 0) return dp[r][c];
		
		dp[r][c] = (dp(r - 1, c) + dp(r, c - 1)) % INF;
		return dp[r][c];
	}
	
    public int solution(int m, int n, int[][] puddles) {
        dp = new long[n + 1][m + 1];
        isPuddles = new boolean[n + 1][m + 1];
        for (int[] pos : puddles) {
        	isPuddles[pos[1]][pos[0]] = true;
        }
        
        dp(n, m);
        
        return (int)dp[n][m];
    }
}