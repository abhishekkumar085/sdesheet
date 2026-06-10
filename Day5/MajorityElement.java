package Day5;

import java.util.HashMap;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j])
                    count++;
            }

            if (count > n / 2) {
                return nums[i];
            }
        }
        return -1;
    }

    // using Hashmap
    public static int majorityElementUsingHashmap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                int frequency = map.get(nums[i]);
                map.put(nums[i], frequency + 1);
            } else {
                map.put(nums[i], 1);
            }
            if (map.get(nums[i]) > n / 2) {
                return nums[i];

            }
        }

        System.out.println(map);
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 3, 4, 4, 4, 4, 4, 4, 4, 1, 2, 3, 4, 5 };
        int result = majorityElementUsingHashmap(nums);
        System.out.println(result);

    }
}
