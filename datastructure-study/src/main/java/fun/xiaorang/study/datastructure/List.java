package fun.xiaorang.study.datastructure;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructure-study">datastructure-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025/04/25 18:11
 */
public interface List<E> extends Iterable<E> {
  /**
   * 返回集合中元素的数量
   *
   * @return 元素数量
   */
  int size();

  /**
   * 判断集合是否为空
   *
   * @return 如果集合为空，则返回 {@code true}，否则返回 {@code false}
   */
  boolean isEmpty();

  /**
   * 判断集合中是否包含指定元素
   *
   * @param o 指定元素
   * @return 如果集合中包含指定元素，则返回 {@code true}，否则返回 {@code false}
   */
  boolean contains(Object o);

  /**
   * 查找指定元素在集合中首次出现的位置
   *
   * @param o 指定元素
   * @return 索引位置，如果集合中不包含指定元素，则返回 {@code -1}
   */
  int indexOf(Object o);

  /**
   * 查找指定元素在集合中最后一次出现的位置
   *
   * @param o 指定元素
   * @return 索引位置，如果集合中不包含指定元素，则返回 {@code -1}
   */
  int lastIndexOf(Object o);

  /**
   * 获取指定索引位置的元素
   *
   * @param index 指定索引位置
   * @return 元素
   * @throws IndexOutOfBoundsException 如果索引越界 ({@code index < 0 || index >= size()})，则抛出此异常
   */
  E get(int index);

  /**
   * 将集合中指定位置的元素替换为指定元素
   *
   * @param index 指定索引位置
   * @param e     元素
   * @return 先前位于指定位置的元素
   * @throws IndexOutOfBoundsException 如果索引越界 ({@code index < 0 || index >= size()})，则抛出此异常
   */
  E set(int index, E e);

  /**
   * 添加元素至集合末尾
   *
   * @param e 待添加的元素
   * @return 如果添加元素成功，则返回 {@code true}，否则返回 {@code false}
   */
  boolean add(E e);

  /**
   * 添加元素至指定索引位置
   *
   * @param index 指定索引位置
   * @param e     待添加的元素
   * @throws IndexOutOfBoundsException 如果索引越界 ({@code index < 0 || index > size()})，则抛出此异常
   */
  void add(int index, E e);

  /**
   * 删除指定索引位置的元素
   *
   * @param index 指定索引位置
   * @return 先前位于指定位置的元素
   * @throws IndexOutOfBoundsException 如果索引越界 ({@code index < 0 || index >= size()})，则抛出此异常
   */
  E remove(int index);

  /**
   * 删除指定元素
   *
   * @param o 指定元素
   * @return 如果删除元素成功，则返回 {@code true}，否则返回 {@code false}
   */
  boolean remove(Object o);

  /**
   * 清空集合中的所有元素
   */
  void clear();
}
