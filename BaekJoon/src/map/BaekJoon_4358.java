package map;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_4358, 생태학
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_4358 {
    static int cnt;
    static Map<String, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        while ((input = br.readLine()) != null && input.length() != 0) {
            if (map.containsKey(input)) {
                map.put(input, map.get(input) + 1);
            } else {
                map.put(input, 1);
            }
            cnt++;
        }
        br.close();
        
        StringBuilder sb = new StringBuilder();
        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String key = it.next();
            sb.append(key).append(" ").append(String.format("%.4f", (double)map.get(key) * 100 / cnt)).append("\n");
        }
        System.out.print(sb);
    }

}
