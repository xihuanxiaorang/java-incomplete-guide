package fun.xiaorang.study.designpattern.factory.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/java-incomplete-guide">java-incomplete-guide</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025/06/24 18:09
 */
class CourseFactoryTest {
  @Test
  public void test() {
    final ICourse course = CourseFactory.createCourse("java");
    Assertions.assertNotNull(course);
    course.record();
  }
}