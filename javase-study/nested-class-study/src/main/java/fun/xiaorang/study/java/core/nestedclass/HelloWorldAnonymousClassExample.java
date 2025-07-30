package fun.xiaorang.study.java.core.nestedclass;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/java-study">java-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2025/01/15 22:55
 */
public class HelloWorldAnonymousClassExample {

  public void sayHello() {

    // 英语问候 - 局部内部类实现
    class EnglishGreeting implements HelloWorld {
      String name = "world";

      @Override
      public void greet() {
        greetSomeone(name);
      }

      @Override
      public void greetSomeone(String someone) {
        name = someone;
        System.out.println("Hello, " + name);
      }
    }

    HelloWorld englishGreeting = new EnglishGreeting();

    // 法语问候 - 匿名内部类实现
    HelloWorld frenchGreeting = new HelloWorld() {
      String name = "tout le monde";

      @Override
      public void greet() {
        greetSomeone(name);
      }

      @Override
      public void greetSomeone(String someone) {
        name = someone;
        System.out.println("Salut, " + name);
      }
    };

    // 西班牙语问候 - 匿名内部类实现
    HelloWorld spanishGreeting = new HelloWorld() {
      String name = "mundo";

      @Override
      public void greet() {
        greetSomeone("mundo");
      }

      @Override
      public void greetSomeone(String someone) {
        name = someone;
        System.out.println("Hola, " + name);
      }
    };

    englishGreeting.greet();
    frenchGreeting.greetSomeone("Fred");
    spanishGreeting.greet();
  }

  public static void main(String... args) {
    new HelloWorldAnonymousClassExample().sayHello();
  }

  interface HelloWorld {
    void greet();

    void greetSomeone(String someone);
  }
}
