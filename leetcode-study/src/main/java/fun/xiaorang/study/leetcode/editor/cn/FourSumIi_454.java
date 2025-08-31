package fun.xiaorang.study.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liulei
 * @description <a href="https://leetcode.cn/problems/4sum-ii/" style="font-weight:bold;font-size:11px;">454.四数相加 II<a/>
 * @github <a href="https://github.com/xihuanxiaorang/java-study">java-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025-08-30 22:25:58
 */
@SuppressWarnings({"all"})
public class FourSumIi_454 {
  public static void main(String[] args) {
    final Solution solution = new FourSumIi_454().new Solution();
    final int[] nums1 = new int[]{1, 2};
    final int[] nums2 = new int[]{-2, -1};
    final int[] nums3 = new int[]{-1, 2};
    final int[] nums4 = new int[]{0, 2};
    System.out.println(solution.fourSumCount(nums1, nums2, nums3, nums4));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    /**
     * 计算四个数组中元素之和为零的四元组的数量。
     *
     * @param nums1 第一个整数数组
     * @param nums2 第二个整数数组
     * @param nums3 第三个整数数组
     * @param nums4 第四个整数数组
     * @return 四元组的数量，使得 nums1[i] + nums2[j] + nums3[k] + nums4[l] = 0
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
      // 创建一个哈希表用来存储 nums1 和 nums2 中每对元素之和及其出现的次数
      final Map<Integer, Integer> table = new HashMap<>();
      // 遍历 nums1 和 nums2 的每一对元素
      for (int u : nums1)
        for (int v : nums2)
          // 计算每对元素之和，将其存入哈希表，并记录其出现的次数
          table.put(u + v, table.getOrDefault(u + v, 0) + 1);

      // 初始化计数器
      int count = 0;
      // 遍历 nums3 和 nums4 的每一对元素
      for (int u : nums3)
        for (int v : nums4)
          // 获取 0 - (u + v) 在哈希表中出现的次数（如果不存在则返回 0），并累加到计数器中
          count += table.getOrDefault(-(u + v), 0);

      // 返回满足条件的四元组数量
      return count;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}