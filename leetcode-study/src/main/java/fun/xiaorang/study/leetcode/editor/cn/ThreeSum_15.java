package fun.xiaorang.study.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liulei
 * @description <a href="https://leetcode.cn/problems/3sum/" style="font-weight:bold;font-size:11px;">15.三数之和<a/>
 * @github <a href="https://github.com/xihuanxiaorang/java-study">java-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025-08-31 10:43:19
 */
@SuppressWarnings({"all"})
public class ThreeSum_15 {
  public static void main(String[] args) {
    final Solution solution = new ThreeSum_15().new Solution();
    final int[] nums = {-1, 0, 1, 2, -1, -4};
    final List<List<Integer>> ans = solution.threeSum(nums);
    System.out.println(ans);
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    /**
     * 返回数组中所有和为零且不重复的三元组。
     *
     * @param nums 整数数组
     * @return 所有和为零且不重复的三元组集合
     */
    public List<List<Integer>> threeSum(int[] nums) {
      // 获取数组长度
      int n = nums.length;
      // 创建一个集合来存储结果
      List<List<Integer>> ans = new ArrayList<>();
      // 对数组进行排序，以便后续使用双指针法
      Arrays.sort(nums);
      // 遍历数组中的每个元素，作为第一个元素
      for (int i = 0; i < n - 2; i++) {
        // 跳过重复的元素，避免重复计算
        if (i > 0 && nums[i] == nums[i - 1]) continue;
        // 如果当前元素与后面两个最小的元素之和大于 0，则直接跳出循环
        if (nums[i] + nums[i + 1] + nums[i + 2] > 0) break;
        // 如果当前元素与后面两个最大的元素之和小于 0，则跳过当前元素
        if (nums[i] + nums[n - 2] + nums[n - 1] < 0) continue;
        // 初始化左右指针
        int left = i + 1, right = n - 1;
        // 使用双指针法查找满足条件的三元组
        while (left < right) {
          // 计算当前三元组的和
          int sum = nums[i] + nums[left] + nums[right];
          // 如果和大于 0，说明右指针指向的值太大，需要向左移动右指针
          if (sum > 0) {
            right--;
          }
          // 如果和小于 0，说明左指针指向的值太小，需要向右移动左指针
          else if (sum < 0) {
            left++;
          }
          // 如果和等于 0，找到一个满足条件的三元组
          else {
            // 将找到的三元组添加到结果集合中
            ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
            // 移动左指针，并跳过重复的元素
            left++;
            while (left < right && nums[left] == nums[left - 1]) left++;
            // 移动右指针，并跳过重复的元素
            right--;
            while (left < right && nums[right] == nums[right + 1]) right--;
          }
        }
      }
      // 返回结果集合
      return ans;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}