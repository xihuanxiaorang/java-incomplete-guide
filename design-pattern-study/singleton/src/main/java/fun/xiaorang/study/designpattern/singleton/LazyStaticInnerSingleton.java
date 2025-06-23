package fun.xiaorang.study.designpattern.singleton;

import java.io.Serializable;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/design-pattern-study">design-pattern-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025/06/17 18:41
 */
public class LazyStaticInnerSingleton implements Serializable {
  private static boolean initialized = false;

  private LazyStaticInnerSingleton() {
    if (initialized) {
      throw new RuntimeException("单例对象禁止重复创建");
    }
    initialized = true;
  }

  private Object readResolve() {
    return getInstance();
  }

  public static LazyStaticInnerSingleton getInstance() {
    return SingletonHolder.INSTANCE;
  }

  private static class SingletonHolder {
    private static final LazyStaticInnerSingleton INSTANCE = new LazyStaticInnerSingleton();
  }
}
