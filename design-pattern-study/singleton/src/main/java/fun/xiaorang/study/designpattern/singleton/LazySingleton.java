package fun.xiaorang.study.designpattern.singleton;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; ">懒汉式<p/>
 * @github <a href="https://github.com/xihuanxiaorang/design-pattern-study">design-pattern-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025/06/16 22:48
 */
public class LazySingleton {
  private static LazySingleton INSTANCE;

  private LazySingleton() {
  }

  public static LazySingleton getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new LazySingleton();
    }
    return INSTANCE;
  }
}
