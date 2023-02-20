package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BaekJoon_10825, 국영수
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_10825 {
    static class Student implements Comparable<Student> {
        String name;
        int korean, english, math;
        
        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if (this.korean == o.korean) {
                if (this.english == o.english) {
                    if (this.math == o.math) { 
                        return this.name.compareTo(o.name);
                    }
                    return o.math - this.math;
                }
                return this.english - o.english;
            }
            return o.korean - this.korean;
        }

        @Override
        public String toString() {
            return "Student [name=" + name + ", korean=" + korean + ", english=" + english + ", math=" + math + "]";
        }
    }
    
    static int N;
    static Student[] students;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        students = new Student[N];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            students[i] = new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(students);
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) sb.append(students[i].name).append("\n");
        System.out.println(sb.toString().trim());
    }

}
