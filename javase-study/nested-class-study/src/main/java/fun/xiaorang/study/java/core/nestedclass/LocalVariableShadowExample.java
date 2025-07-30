package fun.xiaorang.study.java.core.nestedclass;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/java-incomplete-guide">java-incomplete-guide</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025/07/26 23:20
 */
public class LocalVariableShadowExample {
  public int x = 0;

  public void printValue(int x) {
    // 局部变量
    System.out.println("LocalVariable.x = " + x);

    class LocalInnerClass {
      final int x = 1;

      public void printValue() {
        // 成员内部类的同名成员变量
        System.out.println("LocalInnerClass.x = " + this.x);
        // 外部类的同名成员变量
        System.out.println("OuterClass.x = " + LocalVariableShadowExample.this.x);
      }
    }

    // 创建局部类实例
    final LocalInnerClass localInnerClass = new LocalInnerClass();
    localInnerClass.printValue();
  }

  public static void main(String[] args) {
    new LocalVariableShadowExample().printValue(23);
  }
}
