package fun.xiaorang.study.java.core.nestedclass;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/java-incomplete-guide">java-incomplete-guide</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025/07/27 23:09
 */
public class AnonymousVariableShadowExample {
  public int x = 0;

  public void printValue(int x) {
    // 局部变量
    System.out.println("LocalVariable.x = " + x);

    final Runnable runnable = new Runnable() {
      final int x = 1;

      @Override
      public void run() {
        // 匿名内部类的同名成员变量
        System.out.println("AnonymousClass.x = " + this.x);
        // 外部类的同名成员变量
        System.out.println("OuterClass.x = " + AnonymousVariableShadowExample.this.x);
      }
    };

    runnable.run();
  }

  public static void main(String[] args) {
    new AnonymousVariableShadowExample().printValue(23);
  }
}
