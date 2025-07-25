package fun.xiaorang.study.core.codeblock;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/java-incomplete-guide">java-incomplete-guide</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025/07/23 22:20
 */
public class InstanceCodeBlock {
  // 实例变量
  int instanceVariable;

  // 实例代码块：每次创建对象时都会执行，并且先于构造方法执行
  {
    instanceVariable = 10;
    System.out.println("[Instance Code Block] Executed.");
  }

  // 构造方法（每次创建对象都会调用）
  public InstanceCodeBlock() {
    System.out.println("[Constructor] Called.");
  }

  public static void main(String[] args) {
    System.out.println("Main start.");
    InstanceCodeBlock o1 = new InstanceCodeBlock();
    System.out.println("Instance variable: " + o1.instanceVariable);
    InstanceCodeBlock o2 = new InstanceCodeBlock();
    System.out.println("Instance variable: " + o2.instanceVariable);
  }
}
