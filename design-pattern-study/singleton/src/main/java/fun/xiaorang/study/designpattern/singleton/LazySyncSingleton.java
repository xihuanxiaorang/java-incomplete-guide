package fun.xiaorang.study.designpattern.singleton;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; ">Synchronized同步<p/>
 * @github <a href="https://github.com/xihuanxiaorang/design-pattern-study">design-pattern-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025/06/16 23:05
 */
public class LazySyncSingleton {
  private static LazySyncSingleton INSTANCE;

  private LazySyncSingleton() {
  }

  public static synchronized LazySyncSingleton getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new LazySyncSingleton();
    }
    return INSTANCE;
  }
}
