package fun.xiaorang.study.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liulei
 * @description <a href="https://leetcode.cn/problems/intersection-of-two-arrays/" style="font-weight:bold;font-size:11px;">349.两个数组的交集<a/>
 * @github <a href="https://github.com/xihuanxiaorang/java-study">java-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025-08-29 16:59:06
 */
@SuppressWarnings({"all"})
public class IntersectionOfTwoArrays_349 {
  public static void main(String[] args) {
    final Solution solution = new IntersectionOfTwoArrays_349().new Solution();
    final int[] nums1 = {1, 2, 2, 1};
    final int[] nums2 = {2, 2};
    final int[] ans = solution.intersection(nums1, nums2);
    System.out.println(Arrays.toString(ans));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    /**
     * 计算两个数组的交集。
     *
     * @param {int[]} nums1 - 第一个整数数组
     * @param {int[]} nums2 - 第二个整数数组
     * @return {int[]} 两个数组的交集
     */
    public int[] intersection(int[] nums1, int[] nums2) {
      // 如果 nums1 的长度大于 nums2 的长度，则交换两个数组，确保 nums1 是较短的那个
      if (nums1.length > nums2.length) return intersection(nums2, nums1);

      // 创建一个 HashSet 来存储 nums1 中的所有元素
      final Set<Integer> table = new HashSet<>(nums1.length);
      for (int num : nums1) {
        // 将 nums1 中的每个元素添加到 HashSet 中
        table.add(num);
      }

      // 创建另一个 HashSet 来存储交集结果
      final Set<Integer> ans = new HashSet<>();
      for (int num : nums2) {
        // 检查 nums2 中的每个元素是否在 nums1 的 HashSet 中
        if (table.contains(num)) {
          // 如果存在，则将该元素添加到结果 HashSet 中
          ans.add(num);
        }
      }
      
      // 将结果 HashSet 转换为 int 数组并返回
      return ans.stream().mapToInt(Integer::intValue).toArray();
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}