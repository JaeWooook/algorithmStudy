package Java.InflearnAndLeetCode.Array;

import java.util.Scanner;

public class Ex_0205_02 {
    public int solution(int num) {
        //20
        int answer = 0;
        int[] ch = new int[num+1];
        for(int i=2; i<=num; i++) {
            if(ch[i]==0) {
                answer++;
                for(int j=i; j<=num; j+=i) {
                    //곱하기는 풀어서 생각하면 더하기다 각 숫자의 배수들을 모두 1로 만들어준다.
                    //예를 들면, 2의 배수를 전부 1로 체크하는 행동이다. j=j+i 를 함으로써 i가 해당수의 배수가 되는것이다.
                    ch[j]=1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ex_0205_02 T = new Ex_0205_02();
        Scanner in=new Scanner(System.in);
        int i = in.nextInt();
        System.out.print(T.solution(i));
        return ;
    }
}
