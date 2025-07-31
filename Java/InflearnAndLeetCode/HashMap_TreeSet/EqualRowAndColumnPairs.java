package Java.InflearnAndLeetCode.HashMap_TreeSet;

import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColumnPairs {

    static int equalPairs(int[][] grid) {

        int answer = 0;
        Map<String, Integer> matrixMap = new HashMap<String, Integer>();
        for(int i=0; i<grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<grid[i].length; j++) {
                sb.append(String.valueOf(grid[i][j]));
                if(j != grid[i].length -1) {
                    sb.append(",");
                }
            }
            matrixMap.put(sb.toString(), matrixMap.getOrDefault(sb.toString(), 0) + 1);
        }

        for(int i=0; i<grid.length; i++) {
            StringBuilder sb2 = new StringBuilder();
            for(int j=0; j<grid.length; j++) {
                sb2.append(String.valueOf(grid[j][i]));
                if(j != grid.length - 1) {
                    sb2.append(",");
                }
            }
            if(matrixMap.containsKey(sb2.toString())) {
                if(matrixMap.get(sb2.toString()) > 1) {
                    answer += matrixMap.get(sb2.toString());
                } else {
                    answer++;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int[][] grid = {
            {3,2,1},
            {1,7,6},
            {2,7,7}
        };

        int[][] grid2 = {
            {13, 13},
            {13, 13}
        };

        int[][] grid3 = {
            {3, 1, 2, 2},
            {1, 4, 4, 5},
            {2, 4, 2, 2},
            {2, 4, 2, 2}
        };

        System.out.println(equalPairs(grid2));
    }
}
