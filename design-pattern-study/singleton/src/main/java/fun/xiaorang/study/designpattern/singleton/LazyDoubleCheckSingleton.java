package fun.xiaorang.study.designpattern.singleton;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; ">双重检查锁<p/>
 * @github <a href="https://github.com/xihuanxiaorang/design-pattern-study">design-pattern-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025/06/16 23:21
 */
public class LazyDoubleCheckSingleton {
  private static volatile LazyDoubleCheckSingleton INSTANCE;

  private LazyDoubleCheckSingleton() {
  }

  public static LazyDoubleCheckSingleton getInstance() {
    if (INSTANCE == null) {
      synchronized (LazyDoubleCheckSingleton.class) {
        if (INSTANCE == null) {
          INSTANCE = new LazyDoubleCheckSingleton();
        }
      }
    }
    return INSTANCE;
  }
}
