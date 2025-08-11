package Java.BOJ.Hash;

//BOJ 1620번
import java.io.*;
import java.util.*;

public class BOJ_2_1620 {

    public static class Main {

        static BufferedReader br;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {

            // 1. 입출력 초기화
            /**
             * 입력 계획
             * 1. 도감 26개를 String 1개의 배열에 넣는다.
             * 2. 문제지를 String 2개의 배열에 넣는다.
             */
            br = new BufferedReader(new InputStreamReader(System.in));


            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());


//        String[] strArr = readStringArray(n); // 문자열 배열 사용
//        String[] strArr2 = readStringArray(m); // 문자열 배열 사용

            String[] strArr = {
                    "Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon", "Charizard",
                    "Squirtle", "Wartortle", "Blastoise", "Caterpie", "Metapod", "Butterfree",
                    "Weedle", "Kakuna", "Beedrill", "Pidgey", "Pidgeotto", "Pidgeot",
                    "Rattata", "Raticate", "Spearow", "Fearow", "Ekans", "Arbok",
                    "Pikachu", "Raichu"
            };

            // 두 번째 데이터 그룹 (strArr2)
            String[] strArr2 = {
                    "25", "Raichu", "3" ,"Pidgey", "Kakuna"
            };

            /**
             * 1.맵을 그냥 출력해야 할듯하다. 어째거나, 숫자와 문자를 출력 하는 문제 이다.
             * 2.우선 답이 숫자인지, 한글인지를 구분해야한다.
             * 3.Integer를 키로하는 도감이랑, String을 키로하는 도감 2개를 만들면 2중포문안한다. 접근방법
             */

            HashMap<String, Integer> strDogam = new HashMap<String, Integer>();
            HashMap<Integer, String> intDogam = new HashMap<Integer, String>();
            for(int i=0; i<strArr.length; i++) {
                strDogam.put(strArr[i], i+1);
                intDogam.put(i+1, strArr[i]);
            }

            //답 출력하기
            for(String answer: strArr2) {
                if(Character.isDigit(answer.charAt(0))) {
                    System.out.println(intDogam.get(Integer.valueOf(answer)));
                } else {
                    System.out.println(strDogam.get(answer));
                }
            }
        }

        static String[] readStringArray(int size) throws IOException {
            String[] arr = new String[size];
            for (int i = 0; i < size; i++) {
                arr[i] = br.readLine();
            }
            return arr;
        }
    }
}
