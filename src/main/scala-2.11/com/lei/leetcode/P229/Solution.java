package com.lei.leetcode.P229;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // candi2 = 1是为了防止全是0的情况，这样在candi1的时候就可以截断不继续到candi2
        int candi1 = 0, candi2 = 1, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (candi1 == num) count1++;
            else if (candi2 == num) count2++;
            else if (count1 == 0) {
                candi1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candi2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int c1 = 0, c2 = 0;
        for (int num : nums) {
            if (num == candi1) c1++;
            else if (num == candi2) c2++;
        }
        if (c1 > nums.length / 3) ans.add(candi1);
        else if (c2 > nums.length / 3) ans.add(candi2);
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.majorityElement(new int[]{0, 0, 0}));
    }
}
