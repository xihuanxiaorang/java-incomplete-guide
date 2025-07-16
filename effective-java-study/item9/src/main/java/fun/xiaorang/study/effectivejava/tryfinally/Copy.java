package fun.xiaorang.study.effectivejava.tryfinally;

import java.io.*;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/java-incomplete-guide">java-incomplete-guide</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025/07/16 18:28
 */
public class Copy {
  private static final int BUFFER_SIZE = 8 * 1024;

  static void copy(String src, String dst) throws IOException {
    final InputStream in = new FileInputStream(src);
    try {
      final OutputStream out = new FileOutputStream(dst);
      try {
        final byte[] buff = new byte[BUFFER_SIZE];
        int n;
        while ((n = in.read(buff)) >= 0) {
          out.write(buff, 0, n);
        }
      } finally {
        out.close();
      }
    } finally {
      in.close();
    }
  }

  public static void main(String[] args) throws IOException {
    String src = args[0];
    String dst = args[1];
    copy(src, dst);
  }
}
