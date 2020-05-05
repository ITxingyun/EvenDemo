package com.example.baselib.arithmetic;

public class TwoSum {

//    @Test
//    public void test_two_sum() {
//        int[] testArray = new int[]{1, 4, 3, 5};
//        assertArrayEquals(twoSum(testArray, 4), new int[]{0, 2});
//        assertArrayEquals(twoSum(testArray, 5), new int[]{0, 1});
//        assertArrayEquals(twoSum(testArray, 6), new int[]{0, 3});
//        assertArrayEquals(twoSum(testArray, 7), new int[]{1, 2});
//        assertArrayEquals(twoSum(testArray, 8), new int[]{2, 3});
//        assertArrayEquals(twoSum(testArray, 9), new int[]{1, 3});
//    }


    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    private int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

}
