package fun.xiaorang.study.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author liulei
 * @description <a href="https://leetcode.cn/problems/spiral-matrix-ii/" style="font-weight:bold;font-size:11px;">59.螺旋矩阵 II<a/>
 * @github <a href="https://github.com/xihuanxiaorang/java-study">java-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025-08-18 18:05:47
 */
@SuppressWarnings({"all"})
public class SpiralMatrixIi_59 {
  public static void main(String[] args) {
    final Solution solution = new SpiralMatrixIi_59().new Solution();
    final int n = 4;
    final int[][] ans = solution.generateMatrix(n);
    Arrays.stream(ans).forEach(item -> System.out.println(Arrays.toString(item)));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[][] generateMatrix(int n) {
      // 初始化结果矩阵
      int[][] ans = new int[n][n];
      // 定义边界：t=上边界，b=下边界，l=左边界，r=右边界
      int t = 0, b = n - 1, l = 0, r = n - 1;
      // 当前要填入的数字
      int num = 1;
      // 按照顺时针方向不断填数，直到矩阵填满
      while (true) {
        // 1. 从左到右填充上边界
        for (int j = l; j <= r; j++) ans[t][j] = num++;
        // 上边界向内缩 1，若越界则结束循环
        if (++t > b) break;
        // 2. 从上到下填充右边界
        for (int i = t; i <= b; i++) ans[i][r] = num++;
        // 右边界向内缩 1，若越界则结束循环
        if (--r < l) break;
        // 3. 从右到左填充下边界
        for (int j = r; j >= l; j--) ans[b][j] = num++;
        // 下边界向内缩 1，若越界则结束循环
        if (--b < t) break;
        // 4. 从下到上填充左边界
        for (int i = b; i >= t; i--) ans[i][l] = num++;
        // 左边界向内缩 1，若越界则结束循环
        if (++l > r) break;
      }
      // 返回结果矩阵
      return ans;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}