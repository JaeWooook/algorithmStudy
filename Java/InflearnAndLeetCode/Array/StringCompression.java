package Java.InflearnAndLeetCode.Array;

public class StringCompression {
    public static int compress(char[] chars) {
        int write = 0;
        int cnt = 0;

        for(int read = 0; read < chars.length; read++) {
            cnt++;
            if(chars.length - 1 == read) {
                chars[write++] = chars[read];
                // if(chars.length != 1 && chars[read] != chars[read-1]) {
                if(cnt > 1 && cnt < 10) { // 1보다 큰것
                    chars[write++] = (char)(cnt+'0');
                } else if(cnt >= 10) {
                    int max = cnt / 10;
                    for(int i=0; i < max; i++) {
                        chars[write++] = (char)((cnt / 10) + '0');
                        cnt = cnt % 10;
                        if(cnt < 10) {
                            chars[write++] = (char)(cnt + '0');
                        }
                    }
                } else {// 1인경우
                    continue;
                }
                // }
            }

            if(chars.length - 1 != read && chars[read] != chars[read+1]) {
                chars[write++] = chars[read];
                if(cnt > 1 && cnt < 10) { // 1보다 큰것
                    chars[write++] = (char)(cnt+'0');
                } else if(cnt >= 10) {
                    String strCnt = Integer.toString(cnt);
                    for(char c : strCnt.toCharArray()) {
                        chars[write++] = c;
                    }
                } else {// 1인경우
                    cnt = 0;
                    continue;
                }
                cnt = 0;
            }
        }
        return chars.length;
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(compress(chars));
    }

}
