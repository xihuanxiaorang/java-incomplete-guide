package fun.xiaorang.study.leetcode.editor.cn;

/**
 * @author liulei
 * @description <a href="https://leetcode.cn/problems/remove-element/" style="font-weight:bold;font-size:11px;">27.移除元素<a/>
 * @github <a href="https://github.com/xihuanxiaorang/java-study">java-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025-08-19 21:41:09
 */
@SuppressWarnings({"all"})
public class RemoveElement_27 {
  public static void main(String[] args) {
    final Solution solution = new RemoveElement_27().new Solution();
    final int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
    final int val = 2;
    final int ans = solution.removeElement(nums, val);
    System.out.println(ans);
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    /* 快慢指针法：原地删除数组中等于 val 的元素 */
    public int removeElement(int[] nums, int val) {
      // 慢指针 slow：指向下一个应写入保留元素的位置
      int slow = 0;
      // 快指针 fast：用于遍历数组并寻找需要保留的元素
      for (int fast = 0; fast < nums.length; fast++) {
        // 如果当前元素不等于 val，则说明该元素应被保留
        if (nums[fast] != val) {
          // 将当前元素写入 slow 位置，覆盖掉原来的值
          nums[slow] = nums[fast];
          // slow 右移一位，准备写入下一个保留元素
          slow++;
        }
      }
      // 返回新数组的长度，即 slow 的值
      return slow;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}