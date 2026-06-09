package day8.countSubArraywithGivenxorK;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraysWithXorK(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        int xr = 0;
        int count = 0;

        map.put(0, 1);

        for (int num : nums) {

            xr ^= num;

            int required = xr ^ k;

            count += map.getOrDefault(required, 0);

            map.put(xr, map.getOrDefault(xr, 0) + 1);
        }

        return count;
    }
}