package fun.xiaorang.study.core.codeblock;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/java-incomplete-guide">java-incomplete-guide</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025/07/23 12:30
 */
class Child extends Parent {
  static String staticFieldC = initStaticFieldC();

  static {
    System.out.println("Child static block 1");
  }

  static {
    System.out.println("Child static block 2");
  }

  String instanceFieldC = initInstanceFieldC();

  {
    System.out.println("Child instance block 1");
  }

  {
    System.out.println("Child instance block 2");
  }

  public Child() {
    System.out.println("Child constructor");
  }

  String initInstanceFieldC() {
    System.out.println("Child instance field");
    return "instanceFieldC";
  }

  static String initStaticFieldC() {
    System.out.println("Child static field");
    return "staticFieldC";
  }

  public static void main(String[] args) {
    final Child child = new Child();
    System.out.println(child);
  }
}

class Parent {
  static String staticFieldP = initStaticFieldP();

  static {
    System.out.println("Parent static block 1");
  }

  static {
    System.out.println("Parent static block 2");
  }

  String instanceFieldP = initInstanceFieldP();

  {
    System.out.println("Parent instance block 1");
  }

  {
    System.out.println("Parent instance block 2");
  }

  public Parent() {
    System.out.println("Parent constructor");
  }

  String initInstanceFieldP() {
    System.out.println("Parent instance field");
    return "instanceFieldP";
  }

  static String initStaticFieldP() {
    System.out.println("Parent static field");
    return "staticFieldP";
  }
}
