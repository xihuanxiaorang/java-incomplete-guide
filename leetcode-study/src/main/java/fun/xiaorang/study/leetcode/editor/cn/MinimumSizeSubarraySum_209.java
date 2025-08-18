package fun.xiaorang.study.leetcode.editor.cn;

/**
 * @author liulei
 * @description <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/" style="font-weight:bold;font-size:11px;">209.长度最小的子数组<a/>
 * @github <a href="https://github.com/xihuanxiaorang/java-study">java-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025-08-18 17:50:58
 */
@SuppressWarnings({"all"})
public class MinimumSizeSubarraySum_209 {
  public static void main(String[] args) {
    final Solution solution = new MinimumSizeSubarraySum_209().new Solution();
    int target = 7;
    int[] nums = new int[]{2, 3, 1, 2, 4, 3};
    final int ans = solution.minSubArrayLen(target, nums);
    System.out.println(ans);
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int minSubArrayLen(int target, int[] nums) {
      int n = nums.length;
      // 如果数组为空，直接返回 0
      if (n == 0) {
        return 0;
      }
      // i: 左指针，sum: 当前滑动窗口元素和，ans: 最小子数组长度（初始化为极大值）
      int i = 0;
      int sum = 0;
      int ans = Integer.MAX_VALUE;
      // 外层循环：枚举右指针 j，逐步扩展滑动窗口
      for (int j = 0; j < nums.length; j++) {
        // 将 nums[j] 加入窗口，更新元素和
        sum += nums[j];
        // 内层循环：当窗口内元素和满足条件时，尝试收缩左边界
        while (sum >= target) {
          // 窗口 [i, j] 已经是一个可行解，更新最小子数组长度
          ans = Math.min(ans, j - i + 1);
          // 收缩左边界：移除 nums[i]，并右移左指针
          sum -= nums[i];
          i++;
        }
      }
      // 如果 ans 仍为初始值，则说明不存在满足条件的子数组，返回 0，否则返回 ans
      return ans == Integer.MAX_VALUE ? 0 : ans;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}