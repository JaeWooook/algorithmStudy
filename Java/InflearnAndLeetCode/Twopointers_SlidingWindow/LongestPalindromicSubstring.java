package Java.InflearnAndLeetCode.Twopointers_SlidingWindow;

public class LongestPalindromicSubstring {
    static int start = 0;
    static int maxLen = 1;

    public static void main(String[] args) {
        String test = "babad";

        System.out.println(longestPalindrome(test));
    }

    public static String longestPalindrome(String s) {
        char[] arr = s.toCharArray();

        for(int i=0; i<arr.length; i++) {
            expend(arr, i, i);
            expend(arr, i, i+1);
        }
        return s.substring(start, start+maxLen);
    }

    public static void expend(char[] arr, int left, int right) {
        while(left >= 0 && right < arr.length && arr[left] == arr[right]) {
            int len = right - left +1;
            if(len > maxLen) {
                maxLen = len;
                start = left;
            }

            right++;
            left--;
        }

    }
}
