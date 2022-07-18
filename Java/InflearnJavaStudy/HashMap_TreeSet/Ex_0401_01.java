package Java.InflearnJavaStudy.HashMap_TreeSet;

import java.util.HashMap;
import java.util.Scanner;

public class Ex_0401_01 {
    public char solution(int n, String str) {
        //15
        //BACBACCACCBDEDE
        HashMap<Character, Integer> voteMap = new HashMap<>();
        char answer = '\n';
        String groupArr = "ABCDE";
        for(char x: groupArr.toCharArray()) {
            voteMap.put(x,0);
        }

        for(char x : str.toCharArray()) {
            int cnt=0;
            if(x == 'A') {
                cnt = voteMap.get(x);
                cnt += 1;
                voteMap.put(x, cnt);
            } else if (x == 'B') {
                cnt = voteMap.get(x);
                cnt += 1;
                voteMap.put(x, cnt);
            } else if (x == 'C') {
                cnt = voteMap.get(x);
                cnt += 1;
                voteMap.put(x, cnt);
            } else if (x == 'D') {
                cnt = voteMap.get(x);
                cnt += 1;
                voteMap.put(x, cnt);
            } else if (x == 'E') {
                cnt = voteMap.get(x);
                cnt += 1;
                voteMap.put(x, cnt);
            }
        }
        int max = 0;
        for(char x: groupArr.toCharArray()) {
            if(max < voteMap.get(x)) {
                max=voteMap.get(x);
                answer=x;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0401_01 T = new Ex_0401_01();
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();

        System.out.print(T.solution(n,str));
        return ;
    }
}
