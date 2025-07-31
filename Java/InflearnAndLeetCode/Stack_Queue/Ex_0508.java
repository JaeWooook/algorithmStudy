package Java.InflearnAndLeetCode.Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_0508 {
    public int solution(int n, int m, int[] arr) {
        //5 2
        //60 50 70 80 90
        //6 3
        //70 60 90 60 60 60
        int answer = 0;
        int cnt = 0;
        boolean flag = false;
        Queue<Character> queue = new LinkedList<Character>();
        Queue<Integer> compare = new LinkedList<Integer>();

        for(int i=0; i<n; i++) {
            if(i == m) {
                queue.offer('O');
            } else {
                queue.offer('X');
            }
            compare.offer(arr[i]);
        }

        while(answer==0) {
            if(!compare.isEmpty()) {
                int value = compare.poll();
                char temp = queue.poll();
                Queue<Integer> copyQueue = (Queue<Integer>) ((LinkedList<Integer>) compare).clone();
                if(!copyQueue.isEmpty()) {
                    for (int j = 0; j < compare.size(); j++) {
                        int min_value = copyQueue.poll();
                        if (min_value > value) {//더 큰게 하나라도 나오면 진료 불가능
                            compare.offer(value);
                            queue.offer(temp);
                            flag = false;
                            break;
                        } else {
                            flag = true;
                        }
                    }
                }
                if(flag) {//진료 했다.
                    cnt++;
                }
                if(flag && temp == 'O') {
                    answer = cnt;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0508 T = new Ex_0508();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.print(T.solution(n, m , arr));
        return ;
    }
}
