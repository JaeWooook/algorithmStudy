package Java.InflearnJavaStudy.HashMap_TreeSet;

import java.util.HashMap;
import java.util.Scanner;

public class Ex_0402 {
    public String solution(String str1, String str2) {
        //AbaAeCe
        //baeeACA
        HashMap<Character, Integer> str1Map = new HashMap<>();
        HashMap<Character, Integer> str2Map = new HashMap<>();

        for(char a : str1.toCharArray()) {
            str1Map.put(a,str1Map.getOrDefault(a,0)+1);
        }
        for(char b : str2.toCharArray()) {
            str2Map.put(b,str2Map.getOrDefault(b, 0)+1);
        }

        int cnt = str1Map.size();
        for(char key : str1Map.keySet()) {
            if(str1Map.get(key) == str2Map.get(key)) {
                cnt--;
            }
        }

        if(cnt == 0) {
            return "YES";
        }
        return "NO";
    }

    public String solution2(String str1, String str2) {
        //AbaAeCe
        //baeeACA
        HashMap<Character, Integer> map = new HashMap<>();

        for(char a : str1.toCharArray()) {
            map.put(a,map.getOrDefault(a,0)+1);
        }
        for(char b : str2.toCharArray()) {
            if(!map.containsKey(b) || map.get(b) == 0) {//애초에 map에 있는것중 key가없는 것 or 0인것은 존재할 수가 없다.
                return "NO";
            } else {
                map.put(b, map.get(b)-1);
            }
        }

        return "YES";
    }

    public static void main(String[] args){
        Ex_0402 T = new Ex_0402();
        Scanner in=new Scanner(System.in);
        String str1 = in.next();
        String str2 = in.next();

        System.out.print(T.solution(str1,str2));
        return ;
    }
}
