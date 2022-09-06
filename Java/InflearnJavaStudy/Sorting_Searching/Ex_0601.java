package Java.InflearnJavaStudy.Sorting_Searching;

import java.util.Scanner;

public class Ex_0601 {
    public int[] solution(int n, int[] arr) {
        //6
        //13 5 11 7 23 15
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    //선택 정렬
    public int[] solution2(int n, int[] arr) {

        for(int i=0; i<n-1; i++) {//맨끝에까지는 돌지 않는다 어차피 맨 마지막은 자동으로 정렬된다. 앞에서부터 작은순으로 정렬되기 때문에
            int minValue = Integer.MAX_VALUE;
            int idx = 0;
            for(int j=i+1; j<n; j++) {
                if(minValue > arr[j]) {//해당 배열에서 자기자신을 제외한 가장 작은수를 찾고 해당 수를 가장 앞에서 부터 채워넣는 구조라고 생각
                    minValue = arr[j];
                    idx = j;
                }
            }
            int temp  = arr[i];
            arr[i] = minValue;
            arr[idx] = temp;//가장 작은 수가 있는 자리는 현재 비교하고있는 i번째 숫자를 넣어준다.
            //어차피 i번째 보다 뒤에있기 때문에 다음에 비교하면서 순차적으로 오름차순을 만들 수 있다.
        }
        return arr;
    }

    public static void main(String[] args){
        Ex_0601 T = new Ex_0601();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        for(int x : T.solution2(n, arr)) {
            System.out.print(x+" ");
        }
        return ;
    }
}
