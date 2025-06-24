package fun.xiaorang.study.designpattern.factory.simple;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/java-incomplete-guide">java-incomplete-guide</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025/06/24 18:07
 */
public class CourseFactory {
  private CourseFactory() {
  }

  public static ICourse createCourse(String name) {
    if ("java".equals(name)) {
      return new JavaCourse();
    } else if ("python".equals(name)) {
      return new PythonCourse();
    } else {
      return null;
    }
  }
}
