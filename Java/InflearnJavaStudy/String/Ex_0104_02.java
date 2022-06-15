package Java.InflearnJavaStudy.String;
import java.util.*;

public class Ex_0104_02 {
    public ArrayList<String> solution(String[] str) {
        ArrayList<String> answer = new ArrayList<>();

        for(String x : str) {
            char[] s = x.toCharArray();
            int lt = 0;
            int rt = x.length()-1;

            while(lt<rt) {
                char tmp=s[lt];
                s[lt]=s[rt];
                s[rt]=tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0104_02 T = new Ex_0104_02();
        Scanner in= new Scanner(System.in);
        int cnt  = in.nextInt();
        String[] str = new String[cnt];
        for(int i=0; i<cnt; i++) {
            str[i]=in.next();
        }
        for(String dap : T.solution(str)) {
            System.out.println(dap);
        }
    }
}
