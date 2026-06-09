package day8.longestSubStringWithoutReaptingCharacters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        if (s.isEmpty()) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int maxLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();

        while (right < n) {
            char currentChar = s.charAt(right);

            if (charIndexMap.containsKey((currentChar))) {
                left = Math.max(left, charIndexMap.get(currentChar) + 1);
            }
            charIndexMap.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
