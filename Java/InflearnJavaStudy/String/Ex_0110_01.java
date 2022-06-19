package Java.InflearnJavaStudy.String;

import java.util.Scanner;
//오답이다 엣지케이스를 생각하지 않았다.
public class Ex_0110_01 {
    //오답!
    public int[] wrong_solution(String str, char ch) {//teachermode e
        int[] answer = new int[str.length()];
        int cntR = 0, cntL=0;//edge case를 생각하지 않은경우! 첫번째것은 e가 아니라면 항상 1이 찍히는 경우가된다.
        //혹은 맨마지막의 오른쪽엔 아무것도 없을것이기 때문에 e가 아니라면 항상 1이 찍히게 된다.
        int[] tmpR = new int[str.length()];
        int[] tmpL = new int[str.length()];

        for(int i=0; i<str.length(); i++) {
            if(str.indexOf(ch,i)==i) {
                tmpR[i]=0;
                cntR=0;
            } else {
                cntR++;
                tmpR[i]=cntR;
            }
        }
        for(int i=str.length()-1; i>=0; i--) {
            if(str.lastIndexOf(ch,i)==i) {
                tmpL[i]=0;
                cntL=0;
            } else {
                cntL++;
                tmpL[i]=cntL;
            }
        }
        for(int i=0; i<answer.length; i++) {
            if(tmpL[i]<=tmpR[i]) {
                answer[i] = tmpL[i];
            }
            else {
                answer[i] = tmpR[i];
            }
        }
        return answer;
    }
    //정답!
    public int[] solution(String str, char ch) {//teachermode e
        int[] answer = new int[str.length()];
        int cntR = 1000, cntL=1000;//edge case!!
        int[] tmpR = new int[str.length()];
        int[] tmpL = new int[str.length()];

        for(int i=0; i<str.length(); i++) {
            if(str.indexOf(ch,i)==i) {
                tmpR[i]=0;
                cntR=0;
            } else {
                cntR++;
                tmpR[i]=cntR;
            }
        }
        for(int i=str.length()-1; i>=0; i--) {
            if(str.lastIndexOf(ch,i)==i) {
                tmpL[i]=0;
                cntL=0;
            } else {
                cntL++;
                tmpL[i]=cntL;
            }
        }
        for(int i=0; i<answer.length; i++) {
            if(tmpL[i]<=tmpR[i]) {
                answer[i] = tmpL[i];
            }
            else {
                answer[i] = tmpR[i];
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0110_01 T = new Ex_0110_01();
        Scanner in=new Scanner(System.in);
        String s = in.next();
        char c = in.next().charAt(0);//char형으로 받기위한 input
        for(int x : T.solution(s,c)) {
            System.out.print(x+" ");
        }
        return ;
    }
}
