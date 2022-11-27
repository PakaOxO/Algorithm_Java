import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gom03 {
    static int[] cnt;
    static int[] tickets;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cnt = new int[3];
        tickets = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        
        long answer = 0;
        for (int i=0; i<3; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
            tickets[i] += Integer.parseInt(st2.nextToken());
            
            if (cnt[i] >= tickets[i]) {
                answer += tickets[i];
                cnt[i] -= tickets[i];
                tickets[i] = 0;
            } else {
                answer += cnt[i];
                tickets[i] -= cnt[i];
                cnt[i] = 0;
            }
        }
        
        while (true) {
            boolean flag = true;
            for (int i=0; i<3; i++) {
                if (cnt[i] > 0 && tickets[i] > 0) {
                    if (cnt[i] >= tickets[i]) {
                        answer += tickets[i];
                        cnt[i] -= tickets[i];
                        tickets[i] = 0;
                    } else {
                        answer += cnt[i];
                        tickets[i] -= cnt[i];
                        cnt[i] = 0;
                    }
                }
                if (cnt[i] == 0 && tickets[i] >= 3) {
                    int next = tickets[i] / 3;
                    tickets[(i + 1) % 3] += next;
                    tickets[i] -= next  * 3;
                    flag = false;
                }
            }
            if (flag || cnt[0] + cnt[1] + cnt[2] == 0) break;
        }
        System.out.println(answer);
    }

}
