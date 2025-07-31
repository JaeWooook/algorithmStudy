package Java.InflearnAndLeetCode.Twopointers_SlidingWindow;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        //양쪽 끝에서 시작해서 더 낮은숫자인 것을 --해주거나 ++ 해주고 거리와 곱하기 높이해서 제일 큰것을 찾아준다.
        // st <= en일때까지만 동작하도록한다.
        int st = 0;
        int en = height.length - 1;

        while(st<=en) {
            int maxWidth = en - st;
            int maxHeight = 0;
            if(height[st] > height[en]) {
                maxHeight = height[en];
            } else {
                maxHeight = height[st];
            }

            if(max < maxWidth * maxHeight) {
                max = maxWidth * maxHeight;
            }

            if(height[st] > height[en]) {
                en--;
            } else {
                st++;
            }
        }

        return max;
    }

    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(height));
    }
}
