package Java.InflearnAndLeetCode.Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class Ex_0503 {
    public int solution(int n, int[][] borad, int[] move, int k) {
        //5
        //0 0 0 0 0
        //0 0 1 0 3
        //0 2 5 0 1
        //4 2 4 4 2
        //3 5 1 3 1
        //8
        //1 5 3 5 1 2 1 4
        int answer = 0;
        Stack<Integer> basket = new Stack<Integer>();
        for(int mv : move) {
            for(int i=0; i<n; i++) {
                if(borad[i][mv-1] != 0) {
                    if(!basket.isEmpty()) {
                        int compare = basket.pop();
                        if(compare == borad[i][mv-1]) {
                            answer+=2;
                            borad[i][mv-1] = 0;
                        } else {
                            basket.push(compare);
                            basket.push(borad[i][mv-1]);
                            borad[i][mv-1] = 0;
                        }
                    } else {
                        basket.push(borad[i][mv-1]);
                        borad[i][mv-1] = 0;
                    }
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0503 T = new Ex_0503();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[][] = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        int k = in.nextInt();
        int move[] = new int[k];
        for(int i=0; i<k; i++) {
            move[i] = in.nextInt();
        }
        System.out.print(T.solution(n, arr, move, k));
        return ;
    }
}
