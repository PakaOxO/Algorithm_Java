package mst;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_17472, 
 * @author SSAFY
 *
 */
public class BaekJoon_17472 {
	static class Edge implements Comparable<Edge> {
		int s, e, w;
		
		Edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
	
	static int N, M;
	static int[][] map;
	static boolean[][] isVisited;
	static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static Set<int[]> boundaries;
	static int[][] adjArr;
	static List<Edge> edges;
	static int[] p;
	
	static int findSet(int x) {
		if (p[x] != x) p[x] = findSet(p[x]);
		return p[x];
	}
	
	static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if (px == py) return false;
		
		p[py] = px;
		return true;
	}
	
	static void bfs(int r, int c, int iNo) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c });
		isVisited[r][c] = true;
		
		while (q.size() > 0) {
			int[] curr = q.poll();
			map[curr[0]][curr[1]] = iNo;
			for (int i=0; i<4; i++) {
				int nr = curr[0] + drc[i][0];
				int nc = curr[1] + drc[i][1];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || isVisited[nr][nc]) continue;
				if (map[nr][nc] == 0) {
					boundaries.add(new int[] { curr[0], curr[1], iNo });
					continue;
				}
				
				isVisited[nr][nc] = true;
				q.offer(new int[] { nr, nc, iNo });
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		
		isVisited = new boolean[N][M];
		boundaries = new HashSet<>();
		int iNo = 1;
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (isVisited[i][j] || map[i][j] == 0) continue;
				bfs(i, j, iNo);
				iNo++;
			}
		}
		iNo--;

		adjArr = new int[iNo + 1][iNo + 1];
		for (int[] i : adjArr) Arrays.fill(i, Integer.MAX_VALUE);

		edges = new ArrayList<>();
		Iterator<int[]> it = boundaries.iterator();
		while (it.hasNext()) {
			int[] a = it.next();
			for (int j=0; j<4; j++) {
				int dr = drc[j][0];
				int dc = drc[j][1];
				
				int cnt = 0;
				int nr = a[0];
				int nc = a[1];
				while (true) {
					nr += dr;
					nc += dc;
					if (nr < 0 || nc < 0 || nr >= N || nc >= M) break;
					if (map[nr][nc] > 0) {
						if (map[nr][nc] == a[2]) break;
						if (cnt == 1) break;
						if (adjArr[a[2]][map[nr][nc]] <= cnt) break;
						adjArr[a[2]][map[nr][nc]] = cnt;
						break;
					}
					cnt++;
				}
			}
		}
		for (int i=1; i<iNo; i++) {
			for (int j=i+1; j<=iNo; j++) {
				if (adjArr[i][j] == Integer.MAX_VALUE) continue;
				edges.add(new Edge(i, j, adjArr[i][j]));
			}
		}
		Collections.sort(edges);
		
		p = new int[iNo + 1];
		for (int i=1; i<p.length; i++) p[i] = i;
		
		
		int cnt = 0;
		int answer = 0;
		for (int i=0; i<edges.size(); i++) {
			Edge e = edges.get(i);
			boolean flag = union(e.s, e.e);
			if (flag) {
				answer += e.w;
				cnt++;
				if (cnt == iNo - 1) break;
			}
		}
		
		if (cnt < iNo - 1) System.out.println(-1);
		else System.out.println(answer);
	}

}
