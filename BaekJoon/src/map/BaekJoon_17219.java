package map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * BaekJoon_17219, 비밀번호 찾기 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_17219 {
    static int N, K;
    static Map<String, String> pw;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        pw = new HashMap<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            pw.put(st.nextToken(), st.nextToken());
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<K; i++) {
            sb.append(pw.get(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }

}
