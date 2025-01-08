package Java.BigStone.PrefixSum;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {

        int m = 8, n = 3;
        int[] arr = new int[m];

        for(int i=1; i<m+1; i++) {
            arr[i-1] = i;
        }
//        int a1 = 1, a2 = 1, a3 = 3;
//        int b1 = 4, b2 = 5, b3 = 5;
        int[] answer = new int[m];
        int psum = 0;
        for(int i=0; i<m; i++) {
            psum+=arr[i];
            answer[i] = psum;
        }

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i<n; i ++) {
            String num1 = sc.nextLine();
            String num2 = sc.nextLine();

            int a1 = Integer.parseInt(num1);
            int b1 = Integer.parseInt(num2);
            System.out.println(a1 + " , " + b1 + " = " + (answer[b1-1] - (a1 - 1 == 0 ? 0 : answer[a1-2])));
        }
    }
}
