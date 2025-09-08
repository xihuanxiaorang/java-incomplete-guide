package fun.xiaorang.study.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author liulei
 * @description <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/" style="font-weight:bold;font-size:11px;">167.两数之和 II - 输入有序数组<a/>
 * @github <a href="https://github.com/xihuanxiaorang/java-study">java-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025-09-08 19:08:13
 */
@SuppressWarnings({"all"})
public class TwoSumIiInputArrayIsSorted_167 {
  public static void main(String[] args) {
    final Solution solution = new TwoSumIiInputArrayIsSorted_167().new Solution();
    final int[] numbers = {2, 7, 11, 15};
    final int target = 9;
    final int[] ans = solution.twoSum(numbers, target);
    System.out.println(Arrays.toString(ans));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    /**
     * 返回数组中和为目标值的两个数的索引（1-based）。
     *
     * @param numbers 一个已排序的整数数组
     * @param target  目标和
     * @return 两个数的 1-based 索引，如果找不到则返回空数组
     */
    public int[] twoSum(int[] numbers, int target) {
      // 获取数组长度
      final int n = numbers.length;
      // 初始化左右指针
      int left = 0, right = n - 1;
      // 使用双指针法查找满足条件的两个数
      while (left < right) {
        // 计算当前左右指针指向的两个数的和
        final int sum = numbers[left] + numbers[right];
        // 如果和小于目标值，说明左指针指向的值太小，需要向右移动左指针
        if (sum < target) {
          left++;
        }
        // 如果和大于目标值，说明右指针指向的值太大，需要向左移动右指针
        else if (sum > target) {
          right--;
        }
        // 如果和等于目标值，找到满足条件的两个数
        else {
          // 返回 1-based 索引
          return new int[]{left + 1, right + 1};
        }
      }
      // 如果没有找到满足条件的两个数，返回空数组
      return new int[2];
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}