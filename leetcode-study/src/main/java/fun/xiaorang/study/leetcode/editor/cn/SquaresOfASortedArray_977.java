package fun.xiaorang.study.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author liulei
 * @description <a href="https://leetcode.cn/problems/squares-of-a-sorted-array/" style="font-weight:bold;font-size:11px;">977.有序数组的平方<a/>
 * @github <a href="https://github.com/xihuanxiaorang/java-study">java-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025-08-19 22:47:56
 */
@SuppressWarnings({"all"})
public class SquaresOfASortedArray_977 {
  public static void main(String[] args) {
    final Solution solution = new SquaresOfASortedArray_977().new Solution();
    final int[] nums = new int[]{-4, -1, 0, 3, 10};
    final int[] ans = solution.sortedSquares(nums);
    System.out.println(Arrays.toString(ans));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] sortedSquares(int[] nums) {
      int n = nums.length;
      // 结果数组，存放平方后的递增序列
      int[] ans = new int[n];
      // 双指针：i 指向最左端，j 指向最右端
      // p 表示当前要填入结果数组的位置（从后往前）
      for (int i = 0, j = n - 1, p = n - 1; p >= 0; p--) {
        // 分别计算两端元素的平方值
        int x = nums[i] * nums[i];
        int y = nums[j] * nums[j];
        // 比较两端平方值，较大的放入结果数组的末尾
        if (x > y) {
          ans[p] = x;
          // 左指针右移
          i++;
        } else {
          ans[p] = y;
          // 右指针左移
          j--;
        }
      }
      // 返回结果数组
      return ans;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}