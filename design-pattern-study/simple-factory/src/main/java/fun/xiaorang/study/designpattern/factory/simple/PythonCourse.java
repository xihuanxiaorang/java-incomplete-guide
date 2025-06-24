package fun.xiaorang.study.designpattern.factory.simple;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/java-incomplete-guide">java-incomplete-guide</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025/06/24 18:00
 */
public class PythonCourse implements ICourse {
  @Override
  public void record() {
    System.out.println("录制 Python 课程");
  }
}
