package Java.BOJ.String;
import java.io.*;

public class BOJ_12_17609 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;

        public static void main(String[] args) throws IOException {
            //string 응용문제 boj 17609
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용
            String[] strArr = readStringArray(n); // 문자열

            /**
             * 1. 회문 또는 팰린드롬은 앞 뒤 방향으로 볼때 같은 순서의 문자로 구성된 문자열이다.
             * 2. 한문자를 삭제해서 회문이되면 유사회문 팰린드롬이다.
             * 3. 유사회문인지, 회문인지 일반문자열인지
             * 4. 회문이면 0, 유사회문이면1, 그외는 2
             * 5. 다른개 1개만있다면 유사회문이다.
             * 6. 느려도 풀수있는 방법은 브루드포스를 하는방법뿐이다.
             * 7. 우선 stack으로 뒤집어서 원래랑 같은지 확인한다. 그리고 다르다면, dfs를 이용해 1개씩을 제거하고 다시 같은지확인
             * 8. 다르다면 2
             *
             * 7
             * abba
             * summuus
             * xabba
             * xabbay
             * comcom
             * comwwmoc
             * comwwtmoc
             */
            for(int i=0; i<n; i++) {
                int st = 0;
                int en = strArr[i].length() - 1;
                char[] chars = strArr[i].toCharArray();
                int limit = 1;
                boolean case1 = false;
                boolean case2 = false;

                while(st < en) {
                    if(chars[st] == chars[en]) {
                        st++;
                        en--;
                    } else {
                        limit--;
                        if(chars[st+1] == chars[en]) {
                            int case1St = st+1;
                            int case1En = en;
                            while(case1St < case1En) {
                                if(chars[case1St] == chars[case1En]) {
                                    case1St++;
                                    case1En--;
                                } else {
                                    case1 = true;
                                    break;
                                }
                            }
                        } else {
                            case1 = true;
                        }

                        if(chars[st] == chars[en-1]) {
                            int case2St = st;
                            int case2En = en-1;
                            while(case2St < case2En) {
                                if(chars[case2St] == chars[case2En]) {
                                    case2St++;
                                    case2En--;
                                } else {
                                    case2 = true;
                                    break;
                                }
                            }
                        } else {
                            case2 = true;
                        }
                        break;
                    }
                }

                if(limit == 0 && case1 && case2) {
                    sb.append(2).append("\n");
                } else if(limit == 0 && (!case1 || !case2)) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
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
