package fun.xiaorang.study.leetcode.editor.cn;

/**
 * @author liulei
 * @description <a href="https://leetcode.cn/problems/reverse-string-ii/" style="font-weight:bold;font-size:11px;">541.反转字符串 II<a/>
 * @github <a href="https://github.com/xihuanxiaorang/java-study">java-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025-09-11 13:07:55
 */
@SuppressWarnings({"all"})
public class ReverseStringIi_541 {
  public static void main(String[] args) {
    final Solution solution = new ReverseStringIi_541().new Solution();
    final String s = "abcdefgz";
    final int k = 3;
    System.out.println(solution.reverseStr(s, k));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    /**
     * 反转字符串中的每个 2k 字符块的前 k 个字符
     *
     * @param s 输入字符串
     * @param k 每个块的长度
     * @return 反转后的字符串
     */
    public String reverseStr(String s, int k) {
      // 获取字符串长度
      int n = s.length();
      // 将字符串转换为字符数组
      char[] arr = s.toCharArray();
      // 遍历字符串，每次处理一个 2k 长度的区间
      for (int i = 0; i < n; i += 2 * k) {
        // 计算本次需要反转的区间：
        // 正常情况：对区间前 k 个字符执行反转，区间后 k 个字符保持不变，即 [i, i + k - 1]
        // 特殊情况：若剩余字符不足 k 个，则将剩余字符全部反转，即 [i, n - 1]
        reverse(arr, i, Math.min(i + k, n) - 1);
      }
      // 将字符数组转换回字符串并返回
      return new String(arr);
    }

    /**
     * 反转字符数组中指定范围内的字符
     *
     * @param arr   字符数组
     * @param left  范围的起始索引
     * @param right 范围的结束索引
     */
    private void reverse(char[] arr, int left, int right) {
      // 使用双指针法反转字符
      while (left < right) {
        // 交换 left 和 right 指针指向的字符
        char tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
        // 两个指针同时向中间移动，直至相遇或交错
        left++;
        right--;
      }
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}