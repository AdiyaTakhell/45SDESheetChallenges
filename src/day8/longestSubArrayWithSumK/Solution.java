package day8.longestSubArrayWithSumK;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestSubArrayWithSumK(int[] arr, int k) {
        int maxLength = 0;
        int prefixSum = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (prefixSum == k) {
                maxLength = i + 1;

            }
            int remainingSum = prefixSum - k;

            if (prefixSumMap.containsKey(remainingSum)) {
                maxLength = Math.max(maxLength, i - prefixSumMap.get(remainingSum));
            }

            prefixSumMap.putIfAbsent(prefixSum, i);

        }
        return maxLength;
    }
}
