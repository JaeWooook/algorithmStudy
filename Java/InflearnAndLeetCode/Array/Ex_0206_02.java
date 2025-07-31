package Java.InflearnAndLeetCode.Array;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_0206_02 {
    public boolean isPrime(int num) {
        if(num == 1) return false;
            for(int i=2; i<num; i++) {//2부터해서 해당 num에 대한 약수가 존재한다면 소수가 아니다.
                if(num%i==0) return false;
            }
        return true;
    }
    public ArrayList<Integer> solution(int n ,int[] array) {
        //9
        //32 55 62 20 250 370 200 30 100
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for(int i=0; i<n; i++) {
            int tmp=array[i];
            int res=0;
            while(tmp > 0) {//숫자를 뒤집는 방법
                int t=tmp%10;
                res=res*10+t;
                tmp/=10;
            }
            if(isPrime(res)) {
                answer.add(res);
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0206_02 T = new Ex_0206_02();
        Scanner in=new Scanner(System.in);
        int i = in.nextInt();
        int[] array = new int[i];
        for(int a=0; a<i; a++) {
            array[a] = in.nextInt();
        }
        for(int x : T.solution(i, array)) {
            System.out.print(x+" ");
        }
        return ;
    }
}
