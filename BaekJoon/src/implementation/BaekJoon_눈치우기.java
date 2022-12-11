package implementation;

import java.io.*;
import java.util.*;

public class BaekJoon_눈치우기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i=0; i<N; i++) {
            q.offer(Integer.parseInt(st.nextToken()));
        }
        
        int time = 0;
        while (!q.isEmpty()) {
            if (q.size() == 1) {
                if (q.peek() + time > 1440) {
                    time = -1;
                } else
                    time += q.poll();
                break;
            } else {
                int height = q.poll() - 1;
                int height2 = q.poll() - 1;
                if (height > 0) q.offer(height);
                if (height2 > 0) q.offer(height2);
                time++;
            }
        }
        System.out.println(time);
    }

}
