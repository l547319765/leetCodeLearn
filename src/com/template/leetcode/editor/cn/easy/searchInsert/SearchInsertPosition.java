//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找 
// 👍 875 👎 0

package com.template.leetcode.editor.cn.easy.searchInsert;

public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
        solution.searchInsert(new int[]{1, 3}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // log2N
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int ans = nums.length;
            while (left <= right) {
                int min = (right - left) / 2 + left;
                if (nums[min] >= target) {
                    ans = min;
                    right = min - 1;
                } else {
                    left = min + 1;
                }
            }
            return ans;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    //奇数 注意循环的是除以二的结果
    // logN
    private int first(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < (length + 1) / 2; i++) {
            if (target <= nums[i]) {
                return i;
            }
            if (target > nums[length - 1 - i]) {
                return length - i;
            }
            if (target == nums[length - 1 - i]) {
                return length - 1 - i;
            }
        }
        return (length + 1) / 2;
    }
}