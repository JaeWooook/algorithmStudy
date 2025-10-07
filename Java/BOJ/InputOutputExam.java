package Java.BOJ;
//BOJ 7785번
import java.io.*;
import java.util.*;

public class InputOutputExam {

    public static class Main {

        static BufferedReader br;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            // 1. 입출력 초기화
            br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            // ===== 예시 사용 =====
            int n = readInt(); // 단일 정수
            int m = readInt(); // 단일 정수

            st = new StringTokenizer(br.readLine()); //1줄에 2개의 정수입력
            int dobN = Integer.parseInt(st.nextToken());
            int dobM = Integer.parseInt(st.nextToken());

            String str = readLine(); // 문자열

            int[] arr1 = readIntArray(n); // 1차원 배열
            int[] arrByLine = readIntLineByArray(n); //1차원 배열 1줄에 띄어쓰기로 정수입력
            int[][] arr2 = readInt2DArray(n, m); // 2차원 배열

            String[] strArr = readStringArray(n); // 문자열 배열

            String[][] strArr2D = readString2DArray(n, m); // 2차원 문자열 배열 사용


            // ===== 출력 예시 =====
            sb.append("===1차원 정수 배열===\n");
            for (int num : arr1) sb.append(num).append(" ");
            sb.append("\n");

            sb.append("===2차원 정수 배열===\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    sb.append(arr2[i][j]).append(" ");
                }
                sb.append("\n");
            }

            sb.append("===1차원 문자열 배열===\n");
            for (String s : strArr) sb.append(s).append("\n");

            sb.append("===2차원 문자열 배열===\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    sb.append(strArr2D[i][j]).append(" ");
                }
                sb.append("\n");
            }

            System.out.print(sb);
        }

        // ===== 입력 메서드들 =====
        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
        }

        static String readLine() throws IOException {
            return br.readLine();
        }

        static int[] readIntArray(int size) throws IOException {
            int[] arr = new int[size];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            return arr;
        }

        /**
         * 2개의 정수를 연달아 받은후 그 뒤에가 길이라면
         * @param size
         * @return
         * @throws IOException
         */
        static int[] readDobIntArray(int size) throws IOException {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            return arr;
        }

        static int[] readIntLineByArray(int size) throws IOException {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            return arr;
        }

        static int[][] readInt2DArray(int rows, int cols) throws IOException {
            int[][] arr = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < cols; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            return arr;
        }

        static String[] readStringArray(int size) throws IOException {
            String[] arr = new String[size];
            for (int i = 0; i < size; i++) {
                arr[i] = br.readLine();
            }
            return arr;
        }

        static String[][] readString2DArray(int rows, int cols) throws IOException {
            String[][] arr = new String[rows][cols];
            for (int i = 0; i < rows; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < cols; j++) {
                    arr[i][j] = st.nextToken();
                }
            }
            return arr;
        }

        static String[][][] readString3DArray(int n, int m, int k) throws IOException {
            String[][][] arr = new String[n][m][];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    String line = br.readLine();
                    arr[i][j] = line.split(""); // 한 글자씩 저장하고 싶다면
                }
                br.readLine(); // 층 사이의 빈 줄 소비 (마지막 층에서는 null이면 그냥 무시됨)
            }
            return arr;
        }
    }

}
