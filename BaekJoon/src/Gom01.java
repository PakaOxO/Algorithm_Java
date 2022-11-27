import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Gom01 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i=0; i<N; i++) {
            int day = Integer.parseInt(br.readLine().split("-")[1]);
            if (day <= 90) answer++;
        }
        System.out.println(answer);
    }

}
