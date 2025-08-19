package fun.xiaorang.study.leetcode.editor.cn;

/**
 * @author liulei
 * @description <a href="https://leetcode.cn/problems/binary-search/" style="font-weight:bold;font-size:11px;">704.二分查找<a/>
 * @github <a href="https://github.com/xihuanxiaorang/java-study">java-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025-08-19 21:54:41
 */
@SuppressWarnings({"all"})
public class BinarySearch_704 {
  public static void main(String[] args) {
    final Solution solution = new BinarySearch_704().new Solution();
    final int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
    final int target = 9;
    final int ans = solution.search(nums, target);
    System.out.println(ans);
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    /* 二分查找（双闭区间） */
    public int search(int[] nums, int target) {
      // 初始化双闭区间 [0, n-1] ，即 i, j 分别指向数组首元素、尾元素
      int i = 0, j = nums.length - 1;
      // 循环，当搜索区间为空时跳出（当 i > j 时为空）
      while (i <= j) {
        // 计算中点索引 m
        int m = i + (j - i) / 2;
        if (nums[m] < target) { // 此情况说明 target 在区间 [m+1, j] 中
          i = m + 1;
        } else if (nums[m] > target) { // 此情况说明 target 在区间 [i, m-1] 中
          j = m - 1;
        } else { // 找到目标元素，返回其索引
          return m;
        }
      }
      // 未找到目标元素，返回 -1
      return -1;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}