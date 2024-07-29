package implementation;

import java.io.*;
import java.util.*;

class Student {
    public String s;
    public int x;
    
    Student(String s, int x) {
        this.s = s;
        this.x = x;
    }
}

public class BaekJoon_29813 {
    static int N;
    static Queue<Student> q;
    static String answer;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        q = new LinkedList<>();
        StringTokenizer st = null;
        
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int x = Integer.parseInt(st.nextToken());
            q.offer(new Student(s, x));
        }
        
        while (q.size() > 1) {
            Student s = q.poll();
            while (s.x > 1) {
                q.offer(q.poll());
                s.x--;
            }
            q.poll();
        }
        
        answer = q.poll().s;
        System.out.println(answer);
    }

}
