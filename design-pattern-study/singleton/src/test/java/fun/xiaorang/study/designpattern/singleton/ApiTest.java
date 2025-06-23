package fun.xiaorang.study.designpattern.singleton;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/design-pattern-study">design-pattern-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025/06/16 22:51
 */
class ApiTest {
  private static final Logger LOGGER = LoggerFactory.getLogger(ApiTest.class);

  @Test
  public void testHungrySingleton() {
    HungrySingleton hungrySingleton1 = HungrySingleton.getInstance();
    HungrySingleton hungrySingleton2 = HungrySingleton.getInstance();
    LOGGER.info("{}", hungrySingleton1);
    LOGGER.info("{}", hungrySingleton2);
  }

  @Test
  public void testLazySingleton() {
    Runnable runnable = () -> {
      LazySingleton instance = LazySingleton.getInstance();
      LOGGER.info("{}：{}", Thread.currentThread().getName(), instance);
    };
    Thread t1 = new Thread(runnable);
    Thread t2 = new Thread(runnable);
    t1.start();
    t2.start();
  }

  @Test
  public void testLazySyncSingleton() {
    Runnable runnable = () -> {
      LazySyncSingleton instance = LazySyncSingleton.getInstance();
      LOGGER.info("{}：{}", Thread.currentThread().getName(), instance);
    };
    Thread t1 = new Thread(runnable);
    Thread t2 = new Thread(runnable);
    t1.start();
    t2.start();
  }

  @Test
  public void testLazyDoubleCheckSingleton() {
    Runnable runnable = () -> {
      LazyDoubleCheckSingleton instance = LazyDoubleCheckSingleton.getInstance();
      LOGGER.info("{}：{}", Thread.currentThread().getName(), instance);
    };
    Thread t1 = new Thread(runnable);
    Thread t2 = new Thread(runnable);
    t1.start();
    t2.start();
  }

  @Test
  public void testEnumSingleton() {
    Runnable runnable = () -> {
      EnumSingleton instance = EnumSingleton.INSTANCE;
      LOGGER.info("{}：{}", Thread.currentThread().getName(), instance);
    };
    Thread t1 = new Thread(runnable);
    Thread t2 = new Thread(runnable);
    t1.start();
    t2.start();
  }

  @Test
  public void testReflectDestroyLazyStaticInnerSingleton() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    Class<LazyStaticInnerSingleton> clazz = LazyStaticInnerSingleton.class;
    // 通过反射的方式获取私有构造方法
    final Constructor<LazyStaticInnerSingleton> constructor = clazz.getDeclaredConstructor();
    // 关闭访问检查
    constructor.setAccessible(true);
    // 创建对象
    final LazyStaticInnerSingleton instance1 = constructor.newInstance();
    final LazyStaticInnerSingleton instance2 = constructor.newInstance();

    LOGGER.info("instance1: {}", instance1);
    LOGGER.info("instance2: {}", instance2);
    LOGGER.info("是否为同一对象: {}", instance1 == instance2); // false，说明被破坏
  }

  @Test
  public void testDeserializeDestroyLazyStaticInnerSingleton() throws Exception {
    LazyStaticInnerSingleton instance1 = LazyStaticInnerSingleton.getInstance();
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.obj"))) {
      oos.writeObject(instance1);
    }

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.obj"))) {
      LazyStaticInnerSingleton instance2 = (LazyStaticInnerSingleton) ois.readObject();
      LOGGER.info("instance1: {}", instance1);
      LOGGER.info("instance2: {}", instance2);
      LOGGER.info("是否为同一对象: {}", instance1 == instance2); // false，说明被破坏
    }
  }

  @Test
  public void testReflectDestroyEnumSingleton() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    Class<EnumSingleton> clazz = EnumSingleton.class;
    // 通过反射的方式获取私有构造方法
    final Constructor<EnumSingleton> constructor = clazz.getDeclaredConstructor(String.class, int.class);
    // 关闭访问检查
    constructor.setAccessible(true);
    // 创建对象
    final EnumSingleton instance = constructor.newInstance("INSTANCE", 0); // 抛出异常 java.lang.IllegalArgumentException: Cannot reflectively create enum constants
    LOGGER.info("instance: {}", instance);
  }

  @Test
  public void testDeserializeDestroyEnumSingleton() throws Exception {
    EnumSingleton instance1 = EnumSingleton.INSTANCE;
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.obj"))) {
      oos.writeObject(instance1);
    }

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.obj"))) {
      EnumSingleton instance2 = (EnumSingleton) ois.readObject();
      LOGGER.info("instance1: {}", instance1);
      LOGGER.info("instance2: {}", instance2);
      LOGGER.info("是否为同一对象: {}", instance1 == instance2); // false，说明被破坏
    }
  }
}