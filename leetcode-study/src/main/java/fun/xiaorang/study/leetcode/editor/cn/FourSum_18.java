package fun.xiaorang.study.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liulei
 * @description <a href="https://leetcode.cn/problems/4sum/" style="font-weight:bold;font-size:11px;">18.四数之和<a/>
 * @github <a href="https://github.com/xihuanxiaorang/java-study">java-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025-09-09 19:07:33
 */
@SuppressWarnings({"all"})
public class FourSum_18 {
  public static void main(String[] args) {
    final Solution solution = new FourSum_18().new Solution();
    final int[] nums = {1, 0, -1, 0, -2, 2};
    final int target = 0;
    final List<List<Integer>> ans = solution.fourSum(nums, target);
    System.out.println(ans);
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    /**
     * 返回数组中所有和为目标值的四元组。
     *
     * @param nums   整数数组
     * @param target 目标和
     * @return 所有和为目标值的四元组列表
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
      // 创建一个列表来存储结果
      List<List<Integer>> ans = new ArrayList<>();
      // 如果数组为空或长度小于4，直接返回空结果
      if (nums == null || nums.length < 4) return ans;
      // 获取数组长度
      final int n = nums.length;
      // 对数组进行排序，以便后续使用双指针法
      Arrays.sort(nums);
      // 遍历数组中的每个元素，作为第一个元素
      for (int i = 0; i < n - 3; i++) {
        // 去重：跳过重复的元素，避免重复计算
        if (i > 0 && nums[i] == nums[i - 1]) continue;
        // 剪枝：如果当前元素与后面三个最小的元素之和大于目标值，则直接跳出循环
        if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
        // 剪枝：如果当前元素与后面三个最大的元素之和小于目标值，则跳过当前元素
        if ((long) nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) continue;
        // 遍历数组中的每个元素，作为第二个元素
        for (int j = i + 1; j < n - 2; j++) {
          // 去重：跳过重复的元素，避免重复计算
          if (j > i + 1 && nums[j] == nums[j - 1]) continue;
          // 剪枝：如果当前两个元素与后面两个最小的元素之和大于目标值，则直接跳出循环
          if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
          // 剪枝：如果当前两个元素与后面两个最大的元素之和小于目标值，则跳过当前元素
          if ((long) nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) continue;
          // 初始化左右指针
          int left = j + 1, right = n - 1;
          // 使用双指针法查找满足条件的四元组
          while (left < right) {
            // 计算当前四元组的和
            final long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
            // 如果和大于目标值，说明右指针指向的值太大，需要向左移动右指针
            if (sum > target) {
              right--;
            }
            // 如果和小于目标值，说明左指针指向的值太小，需要向右移动左指针
            else if (sum < target) {
              left++;
            }
            // 如果和等于目标值，找到一个满足条件的四元组
            else {
              // 将找到的四元组添加到结果列表中
              ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
              // 移动左指针，并跳过重复的元素
              left++;
              while (left < right && nums[left] == nums[left - 1]) left++;
              // 移动右指针，并跳过重复的元素
              right--;
              while (left < right && nums[right] == nums[right + 1]) right--;
            }
          }
        }
      }
      // 返回结果列表
      return ans;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}