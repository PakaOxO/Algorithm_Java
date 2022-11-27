import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Gom02 {
    static List<String> list;
    static boolean hasName(String name) {
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        list = new ArrayList<>();
        list.add("ChongChong");
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String n1 = st.nextToken();
            String n2 = st.nextToken();
            
            boolean flag1 = hasName(n1);
            boolean flag2 = hasName(n2);
            if (flag1 || flag2) {
                if (!flag1) {
                    list.add(n1);
                }
                if (!flag2) {
                    list.add(n2);
                }
            }
        }
        System.out.println(list.size());
    }

}
