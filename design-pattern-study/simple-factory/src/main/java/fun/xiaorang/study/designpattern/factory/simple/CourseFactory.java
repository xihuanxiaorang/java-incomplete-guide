package fun.xiaorang.study.designpattern.factory.simple;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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

  public static ICourse createCourse() {
    try (InputStream in = CourseFactory.class.getClassLoader().getResourceAsStream("simple-factory.properties")) {
      Properties properties = new Properties();
      properties.load(in);
      final String type = properties.getProperty("type");
      return (ICourse) Class.forName(type).newInstance();
    } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }
}
