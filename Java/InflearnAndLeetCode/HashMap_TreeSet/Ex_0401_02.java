package Java.InflearnAndLeetCode.HashMap_TreeSet;

import java.util.HashMap;
import java.util.Scanner;

public class Ex_0401_02 {
    public char solution(int n, String str) {
        //15
        //BACBACCACCBDEDE
        HashMap<Character, Integer> voteMap = new HashMap<>();
        char answer= '\n';
        for(char x: str.toCharArray()) {
            voteMap.put(x, voteMap.getOrDefault(x, 0)+1);
        }
        int max = Integer.MIN_VALUE;
        for(char key : voteMap.keySet()) {
            if(voteMap.get(key) > max) {
                max=voteMap.get(key);
                answer=key;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ex_0401_02 T = new Ex_0401_02();
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();

        System.out.print(T.solution(n,str));
        return ;
    }
}
