package fun.xiaorang.study.leetcode.editor.cn;

/**
 * @author liulei
 * @description <a href="https://leetcode.cn/problems/reverse-string/" style="font-weight:bold;font-size:11px;">344.反转字符串<a/>
 * @github <a href="https://github.com/xihuanxiaorang/java-study">java-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025-09-10 23:30:57
 */
@SuppressWarnings({"all"})
public class ReverseString_344 {
  public static void main(String[] args) {
    final Solution solution = new ReverseString_344().new Solution();
    final char[] s = {'h', 'e', 'l', 'l', 'o'};
    solution.reverseString(s);
    System.out.println(s);
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    /**
     * 反转字符串
     *
     * @param s 字符数组，表示要反转的字符串
     */
    public void reverseString(char[] s) {
      // 使用双指针：left 从头开始，right 从尾开始
      // 每次交换 left 和 right 指针指向的字符，然后两个指针同时向中间移动，直至相遇或交错
      for (int left = 0, right = s.length - 1; left < right; left++, right--) {
        char tmp = s[left];
        s[left] = s[right];
        s[right] = tmp;
      }
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}