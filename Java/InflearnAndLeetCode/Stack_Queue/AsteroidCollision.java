package Java.InflearnAndLeetCode.Stack_Queue;

import java.util.ArrayList;
import java.util.List;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        //-2 2 -1 -2
        // 10 2 -5
        // -2,1,-2,-2
        // -2,1,1,-2
        List<Integer> stack = new ArrayList<Integer>();
        int top = 0;
        int idx = 0;

        while(top < asteroids.length) {
            int pop = asteroids[top];

            if(top == 0) {
                stack.add(pop);
                top++;
                continue;
            }

            if(!stack.isEmpty() && pop < 0 && stack.get(idx) > 0) {
                int absPop = Math.abs(pop);
                int absCurrent = Math.abs(stack.get(idx));

                if(absPop > absCurrent) {
                    stack.remove(idx--);
                    if(idx >= 0 && (stack.get(idx) > 0 && pop < 0)) {
                        boolean addFlag = false;

                        //또다른 충돌 비교
                        while(idx >= 0 && (stack.get(idx) > 0 && pop < 0)) {
                            absPop = Math.abs(pop);
                            absCurrent = Math.abs(stack.get(idx));

                            if(absPop > absCurrent) {
                                stack.remove(idx--);
                                addFlag = true;
                            } else if(absPop < absCurrent) {
                                addFlag = false;
                                break;
                            } else {
                                addFlag = false;
                                stack.remove(idx);
                                if(idx > 0) idx--;
                                break;
                            }
                        }

                        if(addFlag) {
                            stack.add(pop);
                            if(stack.size() > 1) idx++;
                        }
                    } else {
                        stack.add(pop);
                        idx++;
                    }

                } else if(absPop < absCurrent) {
                    top++;
                    continue;//skip
                } else {
                    stack.remove(idx);
                    if(idx > 0 ) idx--;
                }
            } else {
                stack.add(pop);
                if(stack.size() > 1) idx++;
            }

            top++;
            if(idx < 0) {
                idx = 0;
            }
        }

        int [] result = new int[stack.size()];
        for(int i=0; i<stack.size(); i++) {
            result[i] = stack.get(i);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] asteroids = {1,2,1,-2};
        //10 2 -5
        // 1,-1,-2,-2

        int[] print = asteroidCollision(asteroids);
        for(int i=0; i<print.length; i++) {
            System.out.print(print[i] + " ");
        }
    }
}
