package fun.xiaorang.study.java.core.nestedclass;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/java-study">java-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2025/01/15 22:56
 */
public class MemberVariableShadowExample {
  public int x = 0;

  public static void main(String... args) {
    final InnerClass innerInstance = new MemberVariableShadowExample().new InnerClass();
    innerInstance.printValue(23);
  }

  class InnerClass {
    public int x = 1;

    void printValue(int x) {
      // 局部变量
      System.out.println("LocalVariable.x = " + x);
      // 成员内部类的同名成员变量
      System.out.println("MemberInnerClass.x = " + this.x);
      // 外部类的同名成员变量
      System.out.println("OuterClass.x = " + MemberVariableShadowExample.this.x);
    }
  }
}
