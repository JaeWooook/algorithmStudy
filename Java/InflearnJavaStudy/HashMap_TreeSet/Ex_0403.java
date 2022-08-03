package Java.InflearnJavaStudy.HashMap_TreeSet;

import java.util.HashMap;
import java.util.Scanner;

public class Ex_0403 {
    public int[] solution(int n, int m, int[] arr) {//시간초과
        //7 4
        //20 12 20 10 23 17 10
        int[] answer = new int[arr.length-m+1];
        for(int i=0; i<arr.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            if(i<=arr.length-m) {
                for(int j=i; j<m+i; j++) {
                    map.put(arr[j], map.getOrDefault(arr[j], 0)+1);
                }
            } else {
                break;
            }
            answer[i] = map.size();
        }

        return answer;
    }

    public int[] solution2(int n, int m, int[] arr) {//정답
        //7 4
        //20 12 20 10 23 17 10
        int[] answer = new int[arr.length-m+1];
        HashMap<Integer, Integer> map = new HashMap<>();
        int lt=0;
        int index=0;
        for(int i=0; i<m-1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        for(int i=m-1; i<arr.length; i++) {
            if(i!=m-1) {
                map.put(arr[lt], map.get(arr[lt])-1);
                if(map.get(arr[lt])==0) {
                    map.remove(arr[lt]);
                }
                lt++;
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            answer[index]=map.size();
            index++;
        }

        return answer;
    }
    public static void main(String[] args){
        Ex_0403 T = new Ex_0403();
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i]=in.nextInt();
        }
        for(int x : T.solution2(n,m, arr)) {
            System.out.print(x+" ");
        }
        return ;
    }
}
