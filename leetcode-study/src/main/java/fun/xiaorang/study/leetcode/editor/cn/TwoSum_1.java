package fun.xiaorang.study.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liulei
 * @description <a href="https://leetcode.cn/problems/two-sum/" style="font-weight:bold;font-size:11px;">1.两数之和<a/>
 * @github <a href="https://github.com/xihuanxiaorang/java-study">java-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025-08-30 17:01:09
 */
@SuppressWarnings({"all"})
public class TwoSum_1 {
  public static void main(String[] args) {
    final Solution solution = new TwoSum_1().new Solution();
    final int[] nums = {2, 7, 11, 15};
    final int target = 9;
    final int[] ans = solution.twoSum(nums, target);
    System.out.println(Arrays.toString(ans));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    /**
     * 返回数组中和为目标值的两个数的索引。
     *
     * @param {int[]} nums - 整数数组
     * @param {int}   target - 目标和
     * @return {int[]} 两个数的索引，如果找不到则返回空数组
     */
    public int[] twoSum(int[] nums, int target) {
      // 创建一个哈希表来存储每个元素及其对应的索引
      final Map<Integer, Integer> table = new HashMap<>();
      // 遍历数组中的每个元素
      for (int i = 0; i < nums.length; i++) {
        // 检查目标值减去当前元素的结果是否在哈希表中
        if (table.containsKey(target - nums[i])) {
          // 如果找到，则返回这两个元素的索引
          return new int[]{table.get(target - nums[i]), i};
        }
        // 将当前元素及其索引存入哈希表
        table.put(nums[i], i);
      }
      // 如果没有找到满足条件的两个元素，返回空数组
      return new int[0];
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}