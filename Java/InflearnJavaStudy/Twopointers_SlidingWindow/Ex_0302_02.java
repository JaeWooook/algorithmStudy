package Java.InflearnJavaStudy.Twopointers_SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//Two Pointer
public class Ex_0302_02 {//시간초과 발생
    public ArrayList<Integer> solution(int n , int m, int[] array1, int[] array2) {
        //5
        //1 3 9 5 2
        //5
        //3 2 5 7 8
        int[] tmp = new int[n+m];
        ArrayList<Integer> answer = new ArrayList<>();
        int a=0, b=0;
        while(a<n && b<m) {
            if(n<=m) {
                if(array1[a] == array2[b]) {
                    tmp[a] = array1[a];
                    a++; b=0;
                } else {
                    b++;
                    if(b==m) {
                        a++;b=0;
                    }
                }
            }
            if(m<n) {
                if(array1[a] == array2[b]) {
                    tmp[b] = array1[b];
                    b++; a=0;
                } else {
                    a++;
                    if(a==m) {
                        b++;a=0;
                    }
                }
            }
        }

        Arrays.sort(tmp);
        for(int i=0; i<tmp.length; i++) {
            if(tmp[i]!=0) {
                answer.add(tmp[i]);
            }
        }
        return answer;
    }

    public ArrayList<Integer> solution2(int n , int m, int[] array1, int[] array2) {
        //5
        //1 3 9 5 2
        //5
        //3 2 5 7 8
        ArrayList<Integer> answer = new ArrayList<>();
        int i=0, j=0;
        Arrays.sort(array1);
        Arrays.sort(array2);
        while(i<n && j<m) {
            if(array1[i] == array2[j]) {
                answer.add(array1[i]);
                i++; j++;
            } else if(array1[i]<array2[j]) i++;
            else j++;
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0302_02 T = new Ex_0302_02();
        Scanner in=new Scanner(System.in);
        int i = in.nextInt();
        int[] arr1 = new int[i];
        for(int a=0; a<i; a++) {
            arr1[a] = in.nextInt();
        }
        int j = in.nextInt();
        int[] arr2 = new int[j];
        for(int b=0; b<j; b++) {
            arr2[b] = in.nextInt();
        }
        for(int x : T.solution2(i,j, arr1, arr2)) {
            System.out.print(x+" ");
        }
        return ;
    }
}
