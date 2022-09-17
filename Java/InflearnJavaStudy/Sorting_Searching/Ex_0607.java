package Java.InflearnJavaStudy.Sorting_Searching;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ex_0607 implements Comparable<Ex_0607>{
        //5
        //2 7
        //1 3
        //1 2
        //2 5
        //3 6
        public int x, y;
        Ex_0607(int x, int y) {
            this.x=x;
            this.y=y;
        }

        @Override
        public int compareTo(Ex_0607 o) {
            if(this.x==o.x) {
                return this.y - o.y;
            }
            else {
                return this.x-o.x;
            }
        }
    }
    class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Ex_0607> arr  = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int x= in.nextInt();
            int y= in.nextInt();
            arr.add(new Ex_0607(x,y));
        }
        Collections.sort(arr);
        for(Ex_0607 o : arr) System.out.println(o.x+" "+o.y);
        return ;
    }
}
