package Java.InflearnAndLeetCode.HashMap_TreeSet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DetermineIfTwoStringAreClose {
    public static boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) {
            return false;
        }

        Map<Character, Integer> word1Map = new HashMap<Character, Integer>();
        Map<Character, Integer> word2Map = new HashMap<Character, Integer>();
        //edge case

        for(char word : word1.toCharArray()) {
            word1Map.put(word, word1Map.getOrDefault(word, 0) +1);
        }

        for(char word : word2.toCharArray()) {
            word2Map.put(word, word2Map.getOrDefault(word, 0) +1);
        }

        //word1 = "cabbba", word2 = "abbccc"
        int word1Size = word1Map.size();
        int word2Size = word2Map.size();

        if(word1Size == word2Size) {
            for(Character word1Key : word1Map.keySet()) {
                if(!word2Map.containsKey(word1Key)) {
                    return false;
                }
            }

            Iterator<Character> iterator = word1Map.keySet().iterator();

            while (iterator.hasNext()) {
                Character word1key = iterator.next();
                if (word1Map.get(word1key).equals(word2Map.get(word1key))) {
                    iterator.remove(); // word1Map에서 안전하게 제거
                    word2Map.remove(word1key); // 이건 별개 map이므로 여기서 remove 해도 문제 없음
                }
            }
        }

        if(word1Map.size() == word2Map.size()) {
            if(word1Map.size() == 0) {
                return true;
            }

            int[] cntArr1 = new int[word1Map.size()];
            int[] cntArr2 = new int[word2Map.size()];

            int idx=0;
            for(Character word1Key : word1Map.keySet()) {
                cntArr1[idx] = word1Map.get(word1Key);
                idx++;
            }
            idx=0;
            for(Character word2Key : word2Map.keySet()) {
                cntArr2[idx] = word2Map.get(word2Key);
                idx++;
            }

            Arrays.sort(cntArr1);
            Arrays.sort(cntArr2);

            for(int i=0; i<cntArr1.length; i++) {
                if(cntArr1[i] != cntArr2[i]) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }
    public static void main(String[] args) {
        String word1 = "cabbba";
        String word2 = "abbccc";

        System.out.println(closeStrings(word1, word2));
    }
}
