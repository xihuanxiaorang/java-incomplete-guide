package fun.xiaorang.study.leetcode.editor.cn;

/**
 * @author liulei
 * @description <a href="https://leetcode.cn/problems/reverse-words-in-a-string/" style="font-weight:bold;font-size:11px;">151.反转字符串中的单词<a/>
 * @github <a href="https://github.com/xihuanxiaorang/java-study">java-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025-09-12 17:14:14
 */
@SuppressWarnings({"all"})
public class ReverseWordsInAString_151 {
  public static void main(String[] args) {
    final Solution solution = new ReverseWordsInAString_151().new Solution();
    final String s = "  the sky is     blue  ";
    System.out.println(solution.reverseWords(s));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    /**
     * 反转字符串中的单词顺序
     *
     * @param s 输入字符串
     * @return 反转后的字符串
     */
    public String reverseWords(String s) {
      // 去掉首尾空格
      s = s.trim();
      // 创建一个 StringBuilder 用于构建结果字符串
      final StringBuilder sb = new StringBuilder();
      // 初始化右指针和左指针，都指向字符串的末尾
      int right = s.length() - 1, left = right;
      // 从后向前遍历字符串
      while (left >= 0) {
        // 向左找到当前单词的起点（遇到空格时停止）
        while (left >= 0 && s.charAt(left) != ' ') left--;
        // 在每次添加单词前，判断结果中是否已有内容，如果已有内容则在添加单词前先添加一个空格
        if (sb.length() > 0) sb.append(' ');
        // 添加单词到结果中
        sb.append(s, left + 1, right + 1);
        // 跳过字符串中间多余的空格
        while (left >= 0 && s.charAt(left) == ' ') left--;
        // 更新右指针至下一个单词的末尾
        right = left;
      }
      // 返回构建好的结果字符串
      return sb.toString();
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}