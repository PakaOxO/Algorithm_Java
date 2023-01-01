package sort;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1253, 좋다
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_1253 {
    static int N, answer;
    static int[] arr;
    static Map<Integer, Integer> map;
    
    static void addNum(int num) {
        if (map.containsKey(num)) {
            map.put(num, map.get(num) + 1);
        } else {
            map.put(num, 1);
        }
    }
    
    static boolean isGood(int num) {
        if (num == 0) {
            if (map.get(num) > 2)
                return true;
        }
        
        for (int key : map.keySet()) {
            if (key == num) continue;
            
            if (map.containsKey(num - key)) {
                if (num - key == key) {
                    if (map.get(key) > 1)
                        return true;
                    else
                        continue;
                }
                
                if (num - key == num) {
                    if (map.get(num) > 1)
                        return true;
                    else
                        continue;
                }
                
                if (map.get(num - key) > 0)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            addNum(arr[i]);
        }
        
        Arrays.sort(arr);
        for (int i=0; i<N; i++) {
            if (isGood(arr[i])) {
                answer++;
            }
        }
        System.out.println(answer);
    }

}
