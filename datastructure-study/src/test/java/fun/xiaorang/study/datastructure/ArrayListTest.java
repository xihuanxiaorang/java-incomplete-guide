package fun.xiaorang.study.datastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructure-study">datastructure-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025/04/26 13:18
 */
class ArrayListTest {
  @Test
  void test() {
    final List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(3);
    list.add(1, 2);
    list.forEach(System.out::println);
    Assertions.assertEquals(1, list.get(0));
    Assertions.assertEquals(2, list.get(1));
    Assertions.assertEquals(3, list.get(2));
    list.set(0, 4);
    Assertions.assertEquals(4, list.get(0));
    System.out.println(list);
  }
}