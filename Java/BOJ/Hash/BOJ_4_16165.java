package Java.BOJ.Hash;

//BOJ 16165번
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_4_16165 {
    public static class Main {

        static BufferedReader br;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            /**
             * 1. N, M
             */
            br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine()); //1줄에 2개의 정수입력
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            HashMap<String, Object> idol = new HashMap<>();
            for(int i=0; i<n; i++) {
                String key = readLine();
                int len = readInt();
                String[] strArr = readStringArray(len); // 문자열 배열

                TreeSet<String> members = new TreeSet<>();
                members.addAll(Arrays.asList(strArr));

                idol.put(key, members);
            }

            LinkedHashMap<String, Integer> quizMap = new LinkedHashMap<>();
            for(int i=0; i<m; i++) {
                String key = readLine();
                int val = readInt();
                quizMap.put(key, val);
            }

            /**
             * 1. key, treeSet형태로 찾을수있다. key는 팀명, treeSet은 이제 멤버들
             * 2. member들을 찾는게 문제인데. list로 하면은 contains로 찾을수있다. set이나?
             */

            List<String> answer = new ArrayList<>();

            for(String quizStr : quizMap.keySet()) {
                String key = quizStr;
                Integer val = quizMap.get(key);

                //멤버명으로, 팀명 찾기
                if(val.equals(1)) {
                    for(String name : idol.keySet()) {
                        TreeSet<String> tmp = (TreeSet<String>) idol.get(name);
                        if(tmp.contains(key)) {
                            answer.add(name);
                        }
                    }
                } else {//팀명으로 멤버들명 출력
                    TreeSet<String> tmp = (TreeSet<String>) idol.get(key);
                    for(String str : tmp) {
                        answer.add(str);
                    }
                }
            }

            for(String ans : answer) {
                System.out.println(ans);
            }
        }

        // ===== 입력 메서드들 =====
        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
        }

        static String readLine() throws IOException {
            return br.readLine();
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
