package logic;
import java.io.*;
import java.util.*;

/**
 * BaekJoon_16235, 나무 재테크
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 
 *
 */
public class BaekJoon_16235 {
	static class Pos {
		int r, c;
		List<Tree> tList;
		
		Pos(int r, int c) {
			this.r = r;
			this.c = c;
			tList = new ArrayList<>();
		}
	}
	
	static class Tree implements Comparable<Tree> {
		int age;
		boolean isAlive;
		
		Tree(int age) {
			this.age = age;
			this.isAlive = true;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}
	}
	
	static int N, M, K, answer;
	static int[][] A, map;
	static List<Pos> pos;
	static List<Tree>[][] age;
	static int[][] drc = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
	
	static void spring() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				List<Tree> tList = age[i][j];
				if (tList.size() == 0) continue;
				
				Collections.sort(tList);
				for (Tree t : tList) {
					if (t.age <= map[i][j]) {
						map[i][j] -= t.age;
						t.age++;
					} else {
						t.isAlive = false;
					}
				}
			}
		}
	}
	
	static void summer() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				List<Tree> tList = age[i][j];
				int tListSize = tList.size();
				if (tListSize == 0) continue;
				
				for (int k=tListSize-1; k>=0; k--) {
					Tree t = tList.get(k);
					if (t.isAlive) break;
					map[i][j] += t.age / 2;
					tList.remove(t);
					answer--;
				}
			}
		}
	}
	
	static void authum() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				List<Tree> tList = age[i][j];
				if (tList.size() == 0) continue;
				for (Tree t : tList) {
					if (t.age % 5 != 0) continue;
					for (int k=0; k<8; k++) {
						int nr = i + drc[k][0];
						int nc = j + drc[k][1];
						if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
						age[nr][nc].add(new Tree(1));
						answer++;
					}
				}
			}
		}
	}
	
	static void winter() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				map[i][j] += A[i][j];
			}
		}
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		A = new int[N][N];
		map = new int[N][N];
		age = new ArrayList[N][N];
		pos = new ArrayList<>();
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
				age[i][j] = new ArrayList<>();
			}
		}
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			pos.add(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			age[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1].add(new Tree(Integer.parseInt(st.nextToken())));
			answer++;
		}
		br.close();
		
		int year = 0;
		while (year < K) {
			spring();
			summer();
			authum();
			winter();
			year++;
		}
		
		System.out.println(answer);
	}

}
