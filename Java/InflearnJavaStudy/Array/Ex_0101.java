package Java.InflearnJavaStudy.Array;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_0101 {
    //위처럼 int 배열로 안하는 이유는
    //ArrayList로하면 추가 되기 때문에 0이 찍혀서 0을 걸러낼 필요가없다.
//    public int[] solution(int[] array, int num) {
//        //6
//        //7 3 9 5 6 12
//        int[] answer = new int[num];
//        answer[0] = array[0];
//        for(int i=1; i<num; i++) {
//            if(array[i-1] < array[i]) {
//                answer[i]=array[i];
//            }
//        }
//        return answer;
//    }
    public ArrayList<Integer> solution(int[] array, int num) {
        //6
        //7 3 9 5 6 12
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(array[0]);
        for(int i=1; i<num; i++) {
            if(array[i-1] < array[i]) {
                answer.add(array[i]);
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0101 T = new Ex_0101();
        Scanner in=new Scanner(System.in);
        int i = in.nextInt();
        int[] array = new int[i];
        for(int a=0; a<i; a++) {
            array[a] = in.nextInt();
        }
        for(int x : T.solution(array,i)) {
//            if(x != 0 )
            System.out.print(x+" ");//이 부분을 ' '라고 했더니 이상한 숫자가 찍힌다. 주의할것
        }
        return ;
    }
}
