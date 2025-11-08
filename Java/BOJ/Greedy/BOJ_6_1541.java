package Java.BOJ.Greedy;
import java.io.*;
import java.util.*;

public class BOJ_6_1541 {
    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //greedy 기본문제 boj 1541
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            String str = readLine();

            /**
             * 1. +,- 그리고 괄호를 가지고 식을 만들었는데 괄호를 모두 지움
             * 2. 괄호를 적절히 쳐서 이식의 값을 최소로 만드려고한다.
             * 3. 연속해서 두개이상의 연산자는 없다.
             * 4. 우선 순서를 바꿀수는없으닌까 문자인지 숫자인지 구분해야한다.
             * 5. 나는왜캐 브루드포스만 떠오르지 이건 근데 정렬의문제가아닌데
             * 6. 간단하게 생각하면 뺄셈 기호가있다면 덧셈을 먼저하고 큰수를 만든뒤 빼면된다. 뒤에가 더 클수있다면
             * 7. 수식의 개수 -1이 괄호쌍의 개수가된다. 필요한 괄호의
             * 8. 마이너스를 만나기전까지는 그냥 계산한다. 마이너스를 만나면 기준이되어 그 이전과 그 이후값중 큰값을 먼저 계산하도록한다.
             *
             * 55-50+40
             * -> -35
             *
             * 20 + 30 - 50 - 10
             * -> 순서대로하면 50-50 0 - 10 하닌까 -10이다.
             * -> 50 - 50 - 10 인경우 의미없네 어차피 - - 연속된경우는 의미가없다어차피 같은 경우라고 보면된다.
             *
             * 50+40-55 이렇게되면 뒤를 묶어서 50-15 = 35였겠지?
             *
             * 75+15-41+5 -> 44 정답 출력은 54
             *
             * 90 - 46
             *
             * 93-6-0+6 = 81 , 93
             * ->
             *
             * 8+3-4-9+6+1 = -9 , 5
             * -> +11 -13 + 7 = 5
             * -> 음수 전체를 묶어야한다.
             * -> 8+3-(4-(9+6+1)) = 11 - (4 - 16)
             * -> 11 - 4 - 16  = 11 - 20 = -9
             */
            String[] minusFirst = str.split("-");
            int sum = 0;
            for(int i=0; i<minusFirst.length; i++) {
                if(minusFirst[i].indexOf('+') > -1) {
                    int plusSum = 0;
                    String[] plus = minusFirst[i].split("\\+");
                    for(int j=0; j<plus.length; j++) {
                        plusSum += Integer.parseInt(plus[j]);
                    }
                    if(i==0) {
                        sum+=plusSum;
                    } else {
                        sum+= plusSum*-1;
                    }
                } else {
                    if(i==0) {
                        sum+= Integer.parseInt(minusFirst[i]);
                    } else {
                        sum += Integer.parseInt(minusFirst[i]) * -1;
                    }
                }
            }
            sb.append(sum);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static String readLine() throws IOException {
            return br.readLine();
        }
    }
}
