import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 큰 금민수 재풀이
public class Test {
    static int N, M;
	
	static void dfs(int r, int c, int depth) {
		if (c == M) {
		    c = 0;
		    r++;
		}
		if (r == N) return;
	    
	    dfs(r, c + 1, depth + 1);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.close();
	}

}
