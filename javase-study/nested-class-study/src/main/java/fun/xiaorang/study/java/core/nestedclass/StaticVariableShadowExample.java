package fun.xiaorang.study.java.core.nestedclass;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/java-incomplete-guide">java-incomplete-guide</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025/07/25 19:26
 */
public class StaticVariableShadowExample {
  static int x = 0;

  public static void main(String[] args) {
    final StaticInnerClass staticInnerInstance = new StaticInnerClass();
    staticInnerInstance.printValues(23);
  }

  static class StaticInnerClass {
    static int x = 1;

    void printValues(int x) {
      // 局部变量
      System.out.println("LocalVariable.x = " + x);
      // 静态内部类的同名静态成员变量
      System.out.println("StaticInnerClass.x = " + StaticInnerClass.x);
      // 外部类的同名静态成员变量
      System.out.println("OuterClass.x = " + StaticVariableShadowExample.x);
    }
  }
}
