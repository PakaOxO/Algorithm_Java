package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2224, 명제 증명
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 
 *
 */
public class BaekJoon_2224 {
	static class Proposition implements Comparable<Proposition> {
		char s, e;
		
		Proposition(char s, char e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Proposition o) {
			if (this.s == o.s) {
				return this.e < o.e ? -1 : 1;
			}
			return this.s < o.s ? -1 : 1;
		}
	}
	
	static List<Integer> sList;
	static List<Proposition> pList;
	static boolean[][] adjArr;
	static boolean[] isVisited;
	
	static int getIdx(char c) {
		if (c >= 'A' && c <= 'Z') {
			return (int)(c - 'A');
		} else {
			return (int)(c - 'a');
		}
	}
	
	static void bfs(int s) {
//		PriorityQueue<Proposition> pq = new PriorityQueue<>();
//		pq.offer(new Proposition(s, ))
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		adjArr = new boolean[52][25];
		sList = new ArrayList<>();
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char s = st.nextToken().charAt(0);
			st.nextToken();
			char e = st.nextToken().charAt(0);
			
			int idxS = getIdx(s);
			int idxE = getIdx(e);
			adjArr[idxS][idxE] = true;
			sList.add(idxS);
		}
		
		isVisited = new boolean[52];
		for (int s : sList) {
			if (isVisited[s]) continue;
			bfs(s);
		}
	}

}
