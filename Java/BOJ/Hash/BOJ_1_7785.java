package Java.BOJ.Hash;

//BOJ 7785번
import java.io.*;
import java.util.*;

public class BOJ_1_7785 {
    public static class Main {

        static BufferedReader br;

        public static void main(String[] args) throws IOException {
            // 1. 입출력 초기화
            br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            // ===== 예시 사용 =====
            String[][] strArr2D = {{"Baha","enter"}, {"Askar", "enter"}, {"Baha", "leave"}, {"Artem", "enter"}};
            /**
             * 1. enter 이면 hashset에 넣어준다. leave이면 hashset에서 삭제한다. 중복은 없다고 했기 때문에 hashSet사용
             * 2. 하지만 이름의 정렬이 필요하기 때문에 TreeSet을 사용하자.
             */
            TreeSet<String> emp = new TreeSet<String>();
            for(String[] empRow : strArr2D) {
                if("enter".equals(empRow[1])) {
                    emp.add(empRow[0]);
                } else {
                    emp.remove(empRow[0]);
                }
            }

            String[] strArr = emp.descendingSet().toArray(new String[0]);

            sb.append("===1차원 문자열 배열===\n");
            for (String s : strArr) sb.append(s).append("\n");

            System.out.print(sb);
        }
    }

}
