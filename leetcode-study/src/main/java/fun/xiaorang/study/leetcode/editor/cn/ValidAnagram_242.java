package fun.xiaorang.study.leetcode.editor.cn;

/**
 * @author liulei
 * @description <a href="https://leetcode.cn/problems/valid-anagram/" style="font-weight:bold;font-size:11px;">242.有效的字母异位词<a/>
 * @github <a href="https://github.com/xihuanxiaorang/java-study">java-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025-08-28 22:26:49
 */
@SuppressWarnings({"all"})
public class ValidAnagram_242 {
  public static void main(String[] args) {
    final Solution solution = new ValidAnagram_242().new Solution();
    final String s = "anagram";
    final String t = "nagaram";
    System.out.println(solution.isAnagram(s, t));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    /**
     * 检查两个字符串是否是字母异位词。
     *
     * @param s 第一个字符串
     * @param t 第二个字符串
     * @return 如果 s 和 t 是字母异位词则返回 true，否则返回 false
     */
    public boolean isAnagram(String s, String t) {
      // 如果两个字符串长度不同，则它们不可能是字母异位词
      if (s.length() != t.length()) return false;
      // 创建一个长度为 26 的数组来记录每个字母出现的次数
      int[] cnt = new int[26];
      // 遍历字符串 s，统计每个字母出现的次数
      for (int i = 0; i < s.length(); i++) {
        // 将字符转换为对应的索引（'a' -> 0, 'b' -> 1, ...）
        cnt[s.charAt(i) - 'a']++;
      }
      // 遍历字符串 t，减少每个字母出现的次数
      for (int i = 0; i < t.length(); i++) {
        // 将字符转换为对应的索引（'a' -> 0, 'b' -> 1, ...）
        cnt[t.charAt(i) - 'a']--;
        // 如果某个字母在 t 中出现的次数超过了 s 中的次数，则 t 不是 s 的字母异位词
        if (cnt[t.charAt(i) - 'a'] < 0) return false;
      }
      // 如果所有字母的计数都匹配，则 s 和 t 是字母异位词
      return true;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}