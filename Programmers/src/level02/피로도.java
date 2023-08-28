package level02;

class Solution_피로도 {
	int answer = 0;
	int len = 0;
	boolean[] isVisited;
	int[][] d;
	
	private void dfs(int k, int cnt) {
		answer = Math.max(answer, cnt);
		for (int i=0; i<len; i++) {
			if (k < d[i][0] || k < d[i][1] || isVisited[i]) continue;
			isVisited[i] = true;
			dfs(k - d[i][1], cnt + 1);
			isVisited[i] = false;
		}
	}
	
    public int solution(int k, int[][] dungeons) {
    	d = dungeons;
    	len = d.length;
    	isVisited = new boolean[len];
    	
    	dfs(k, 0);
        return answer;
    }
}

public class 피로도 {
	public static void main(String[] args) throws Exception {
		Solution_피로도 s = new Solution_피로도();
		System.out.println(s.solution(80, new int[][] {{80,20},{50,40},{30,10}}));
	}

}
