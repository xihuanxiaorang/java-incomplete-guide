package fun.xiaorang.study.java.core.nestedclass;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/java-study">java-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2025/01/15 22:54
 */
// 顶级类（非嵌套类）
public class TopLevelClass {
  void accessOuter(OuterClass outer) {
    // 不能直接访问外部类的非静态成员
    // System.out.println(OuterClass.instanceField); // 编译错误
    System.out.println(outer.instanceField);
    System.out.println(OuterClass.staticField);
  }
}

