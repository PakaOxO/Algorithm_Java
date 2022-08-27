package heap;
 
import java.util.*;
import java.io.*;

// 절댓값 힙 
public class BaekJoon_11286 {
	static class Data implements Comparable<Data> {
		int abs;
		int value;
		
		Data(int value) {
			this.value = value;
			this.abs = ( value < 0 ) ? -value : value;
		}
		
		@Override
		public int compareTo(Data o) {
			if (this.abs == o.abs) {
				return this.value - o.value;
			}
			return this.abs - o.abs;
		}
	}
	static PriorityQueue<Data> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>();
		for (int i=0; i<N; i++) {
			int q = Integer.parseInt(br.readLine());
			if (q == 0) {
				if (pq.size() > 0) {
					sb.append(pq.poll().value).append("\n");
				}
				else sb.append("0\n");
				continue;
			}
			pq.add(new Data(q));
		}
		System.out.print(sb);
		br.close();
	}

}
