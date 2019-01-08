package org.sang.demo.test;

/**
 * Created by CJF on 2018-12-3.
 */
public class Robo {

    public static void main(String args[]) {
        int[] nums = {5,5,7,9,8,12,16,15,26};
        int num = rob(nums);
        System.out.println(num);
    }

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2;i<nums.length;i++) {
            int A = dp[i-1];
            int B = dp[i-2]+nums[i];
            dp[i] = Math.max(A, B);
        }
        return dp[nums.length-1];
    }
}
