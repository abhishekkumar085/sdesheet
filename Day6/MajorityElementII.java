package Day6;

import java.util.*;

public class MajorityElementII {

    /*
     * Majority Element II (> n/3)
     * Observation
     * At most 2 elements can appear more than n/3 times. why?
     * becasuse:- 3 elements each appearing > n/3 times would exceed n.
     * 
     * Algorithm:-
     * Maintain
     * candidate1, count1
     * candidate2, count2
     * For each number:-
     * 1. If num == candidate1 → count1++
     * 
     * 2. Else if num == candidate2 → count2++
     * 
     * 3. Else if count1 == 0
     * candidate1 = num
     * count1 = 1
     * 
     * 4. Else if count2 == 0
     * candidate2 = num
     * count2 = 1
     * 
     * 5. Else
     * count1--
     * count2--
     * Why Decrement Both?
     * Current number is different from both candidates.
     * So it cancels one vote from each candidate.
     * 
     * Think:-
     * Current number is different from both candidates.
     * So it cancels one vote from each candidate.
     * 
     * Second Pass Required:-
     * First pass only finds possible candidates.
     * Second pass verifies actual frequency.
     * Time : O(n)
     * Space : O(1)
     * 
     * Memory Trick
     * 
     * Imagine an election:
     * 
     * candidate1 = Modi
     * candidate2 = Rahul
     * 
     * Every new vote:
     * - Supports Modi → count1++
     * - Supports Rahul → count2++
     * - Supports someone else → both lose one vote
     * 
     * Interview flow:
     * 
     * Brute Force → count frequency for every element (O(n²)).
     * Better → HashMap frequency count (O(n) time, O(n) space).
     * Optimal → Boyer-Moore (O(n) time, O(1) space).
     */
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (list.contains(nums[i])) {
                continue;
            }

            int cnt = 0;

            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j])
                    cnt++;
            }

            if (cnt > n / 3) {
                list.add(nums[i]);
            }
        }

        return list;

    }

    public static List<Integer> majorityElementOptimize(int[] nums) {

        int count1 = 0, count2 = 0;
        Integer candidate1 = null;
        Integer candidate2 = null;

        for (int num : nums) {

            if (candidate1 != null && num == candidate1) {
                count1++;
            } else if (candidate2 != null && num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1)
                count1++;
            else if (num == candidate2)
                count2++;
        }

        List<Integer> ans = new ArrayList<>();

        if (count1 > nums.length / 3)
            ans.add(candidate1);

        if (count2 > nums.length / 3)
            ans.add(candidate2);

        return ans;
    }

}
