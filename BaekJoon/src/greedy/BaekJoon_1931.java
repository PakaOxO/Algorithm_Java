package greedy;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1931, 회의실 배정 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_1931 {
    static class Meeting implements Comparable<Meeting> {
        int s, e;
        
        Meeting(int s, int e) {
            this.s = s;
            this.e = e;
        }
        
        @Override
        public int compareTo(Meeting o) {
            if (this.e == o.e) {
                return this.s - o.s;
            } return this.e - o.e;
        }
    }
    
    static int N;
    static PriorityQueue<Meeting> meetings;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        meetings = new PriorityQueue<>();
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            meetings.offer(new Meeting(s, e));
        }
        br.close();
            
        Meeting curr = meetings.poll();
        int cnt = 1;
        for (int i=1; i<N; i++) {
            Meeting next = meetings.poll();
            if (next.s < curr.e) continue;
            curr = next;
            cnt++;
        }
        
        System.out.println(cnt);
    }

}
