package fun.xiaorang.study.core.codeblock;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/java-incomplete-guide">java-incomplete-guide</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025/07/23 22:04
 */
public class StaticCodeBlock {
  // 静态变量
  static int staticVariable;

  // 静态初始化块（仅在类首次加载时执行一次）
  static {
    staticVariable = 10;
    System.out.println("[Static Block] Executed.");
  }

  // 构造方法（每次创建对象都会调用）
  public StaticCodeBlock() {
    System.out.println("[Constructor] Called.");
  }

  public static void main(String[] args) {
    System.out.println("Main start.");
    StaticCodeBlock o1 = new StaticCodeBlock();
    System.out.println("Static variable: " + staticVariable);
    StaticCodeBlock o2 = new StaticCodeBlock();
    System.out.println("Static variable: " + staticVariable);
  }
}
