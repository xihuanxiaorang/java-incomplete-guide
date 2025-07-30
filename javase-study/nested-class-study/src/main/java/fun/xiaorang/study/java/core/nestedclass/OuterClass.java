package fun.xiaorang.study.java.core.nestedclass;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/java-study">java-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2025/01/15 22:53
 */
public class OuterClass {
  static String staticField = "Static outer field";
  String instanceField = "Instance outer field";

  public static void main(String[] args) {
    System.out.println("Member inner class:");
    System.out.println("-------------------");
    OuterClass outer = new OuterClass();
    InnerClass memberInner = outer.new InnerClass();
    memberInner.accessOuter();

    System.out.println("\nStatic inner class:");
    System.out.println("--------------------");
    StaticInnerClass staticInner = new StaticInnerClass();
    staticInner.accessOuter(outer);

    System.out.println("\nTop-level class:");
    System.out.println("----------------");
    TopLevelClass topLevel = new TopLevelClass();
    topLevel.accessOuter(outer);
  }

  static class StaticInnerClass {
    void accessOuter(OuterClass outer) {
      // 不能直接访问外部类非静态成员，需要通过实例
      System.out.println(outer.instanceField);
      // 可直接访问外部类的静态成员
      System.out.println(staticField);
    }
  }

  class InnerClass {
    void accessOuter() {
      // 可直接访问外部类所有成员
      System.out.println(instanceField);
      System.out.println(staticField);
    }
  }
}

