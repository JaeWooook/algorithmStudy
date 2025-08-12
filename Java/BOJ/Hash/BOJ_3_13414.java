package Java.BOJ.Hash;

//BOJ 13414번
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_3_13414 {
    public static class Main {

        static BufferedReader br;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            /**
             * 정수 2개 : 수강 가능인원 K, 리스트길이 L, 학생학번 문자열배열
             */
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer(br.readLine()); //1줄에 2개의 정수입력
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            String[] arr1 = readStringArray(m); // 1차원 배열
//            int n = 3;
//            int m = 8;
//            String[] strArr = {"20103324", "20133221", "20133221", "20093778", "20140101", "01234567", "20093778", "20103325"};

            /**
             * 1. 수강신청 버튼 누르면, 순차적으로 대기목록에 들어간다. -> TreeSet?
             * 2. 이미 대기열에 있는아이 수강신청 버튼 누르면 맨뒤로간다. -> TreeSet?
             * 3. 수강신청 버튼 비활 -> 대기목록 맨앞 학생부터 자동으로 수강신청 완료
             * 예시를 참고했을때 비활성화 되고나면 순차적으로 중복인애는 삭제된다고 생각한다 근데
             * 중복클릭을 한것의 가장앞에를 삭제하기 때문에 Map의 원리를 이용해서 put해주면 된다.
             * 그럼 이제 가장 중복의 마지막은 해당 순번이 남게된다.
             */

            //오답
//            TreeMap<Integer, String> rank = new TreeMap<>();
//            HashMap<String, Integer> dup = new HashMap<>();
//            int idx = 0;
//            for(String num : arr1) {
//                if(dup.get(num) == null) {
//                    rank.put(idx, num);
//                    dup.put(num, idx++);
//                } else {
//                    int key = dup.get(num);
//                    dup.remove(num);
//                    rank.remove(key);
//                    rank.put(idx, num);
//                    dup.put(num, idx++);
//                }
//            }
//
//            int min = Math.min(n, m);
//            String[] answer = new String[min];
//            idx = 0;
//            for(Integer key : rank.keySet()) {
//                if(rank.get(key) != null) {
//                    answer[idx++] = rank.get(key);
//                }
//
//                if(idx == min) break;
//            }
            LinkedHashSet<String> rank = new LinkedHashSet<>();

            for(String num : arr1) {
                if(rank.contains(num)) {
                    rank.remove(num);
                }
                rank.add(num);
            }

            //오답이다.
//            int min = Math.min(n, m);
//            String[] answer = new String[min];
//            int i = 0;
//            for(String num : rank) {
//                answer[i++] = num;
//                if(i == min) break;
//            }
//
//            for(String ans : answer) {
//                System.out.println(ans);
//            }
            String[] answer = new String[n];
            int idx = 0;
            for(String s : rank) {
                if(idx < n) {
                    answer[idx] = s;
                    idx++;
                    n--;
                }
            }

            for(int i=0; i<idx; i++) {
                System.out.println(answer[i]);
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

/**
 * 테스트케이스 추가 생성
 */

/*
추가 테스트 케이스 1 — 중복 없음
입력

복사
편집
3 5
20100001
20100002
20100003
20100004
20100005
모든 클릭이 처음이라 중복 없음

앞에서부터 K=3명만 선택

출력

복사
편집
20100001
20100002
20100003
추가 테스트 케이스 2 — 모두 중복 클릭
입력

복사
편집
2 6
20100001
20100002
20100001
20100002
20100001
20100002
클릭 순서 적용 후 마지막 대기목록 순서: 20100001, 20100002

K=2 → 둘 다 수강 가능

출력

복사
편집
20100001
20100002
추가 테스트 케이스 3 — 중간에 중복 섞임
입력

복사
편집
3 7
20100001
20100002
20100001
20100003
20100004
20100002
20100005
마지막 클릭 순서:

20100001 (세 번째 클릭)

20100003

20100004

20100002 (여섯 번째 클릭)

20100005

K=3 → 앞 3명만

출력

복사
편집
20100001
20100003
20100004
추가 테스트 케이스 4 — 앞자리 0 포함
입력

복사
편집
3 6
00000001
00000002
00000003
00000001
00000002
00000004
마지막 순서:

00000003

00000001 (네 번째 클릭)

00000002 (다섯 번째 클릭)

00000004

K=3 → 앞 3명만

출력

복사
편집
00000003
00000001
00000002
추가 테스트 케이스 5 — 신청자 수가 K보다 적음
입력

복사
편집
5 3
20110001
20110002
20110003
신청자가 3명뿐 → 모두 수강 가능

출력

20110001
20110002
20110003
 */