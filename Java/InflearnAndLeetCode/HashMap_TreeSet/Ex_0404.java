package Java.InflearnAndLeetCode.HashMap_TreeSet;

import java.util.HashMap;
import java.util.Scanner;

public class Ex_0404 {
    public int solution(String str1, String str2) {
    //bacaAacba
    //abc
    int answer = 0;
    int lt=0;
    HashMap<Character, Integer> map1 = new HashMap<>();
    HashMap<Character, Integer> map2 = new HashMap<>();
    for(char x : str2.toCharArray()) {
        map2.put(x, map2.getOrDefault(x, 0)+1);
    }

    for(int i=0; i<str2.length()-1; i++) {
        map1.put(str1.charAt(i), map1.getOrDefault(str1.charAt(i),0)+1);
    }
    for(int i=str2.length()-1; i<str1.length(); i++) {
        map1.put(str1.charAt(i), map1.getOrDefault(str1.charAt(i), 0)+1);
        if(map2.equals(map1)) {
            answer++;
        }
        map1.put(str1.charAt(lt), map1.get(str1.charAt(lt))-1);
        if(map1.get(str1.charAt(lt)) == 0) {
            map1.remove(str1.charAt(lt));
        }
        lt++;
    }

    return answer;
}

    public static void main(String[] args){
        Ex_0404 T = new Ex_0404();
        Scanner in=new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        System.out.print(T.solution(str1, str2));
        return ;
    }

}
