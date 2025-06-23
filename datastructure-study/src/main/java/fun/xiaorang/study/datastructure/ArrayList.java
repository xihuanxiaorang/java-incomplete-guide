package fun.xiaorang.study.datastructure;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructure-study">datastructure-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025/04/25 22:11
 */
public class ArrayList<E> implements List<E> {
  /**
   * 默认初始容量
   */
  private static final int DEFAULT_CAPACITY = 10;
  /**
   * 使用有参构造函数明确指定初始容量为0时的共享空数组，当第一次添加元素时，数组容量会扩容至1
   */
  private static final Object[] EMPTY_ELEMENTDATA = {};
  /**
   * 使用无参构造函数初始化时的共享空数组，当第一次添加元素时，数组容量会扩容至 DEFAULT_CAPACITY = 10
   */
  private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
  /**
   * 数组最大容量
   */
  private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
  /**
   * 数组
   */
  private Object[] elementData;
  /**
   * 集合中的元素数量
   */
  private int size;
  /**
   * 集合结构修改次数，当添加元素或删除元素时，修改次数+1
   * 主要用于快速失败机制 fail-fast，在迭代过程中，若检测到集合的结构被修改，就会立即抛出 {@code ConcurrentModificationException} 异常
   */
  private int modCount;

  public ArrayList() {
    this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
  }

  public ArrayList(final int initialCapacity) {
    if (initialCapacity > 0) {
      this.elementData = new Object[initialCapacity];
    } else if (initialCapacity == 0) {
      this.elementData = EMPTY_ELEMENTDATA;
    } else {
      throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
    }
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean contains(final Object o) {
    return indexOf(o) >= 0;
  }

  @Override
  public int indexOf(final Object o) {
    if (o == null) {
      for (int i = 0; i < size; i++) {
        if (elementData[i] == null) {
          return i;
        }
      }
    } else {
      for (int i = 0; i < size; i++) {
        if (o.equals(elementData[i])) {
          return i;
        }
      }
    }
    return -1;
  }

  @Override
  public int lastIndexOf(final Object o) {
    if (o == null) {
      for (int i = size - 1; i >= 0; i--) {
        if (elementData[i] == null) {
          return i;
        }
      }
    } else {
      for (int i = size - 1; i >= 0; i--) {
        if (o.equals(elementData[i])) {
          return i;
        }
      }
    }
    return -1;
  }

  @Override
  public E get(final int index) {
    rangeCheck(index);
    return elementData(index);
  }

  @Override
  public E set(final int index, final E e) {
    rangeCheck(index);
    final E oldValue = elementData(index);
    elementData[index] = e;
    return oldValue;
  }

  @Override
  public boolean add(final E e) {
    // 确定所需的最小容量，如果需要的最小容量 > 数组长度，则进行扩容
    ensureCapacityInternal(size + 1);
    // 将元素添加到数组末尾
    elementData[size++] = e;
    return true;
  }

  @Override
  public void add(final int index, final E e) {
    rangeCheckForAdd(index);
    ensureCapacityInternal(size + 1);
    // 使用 System.arraycopy() 方法将 index 位置之后的元素都向后移动一位
    // 等价于倒序遍历，使用前一个元素的值覆盖当前元素，直至 index 位置为止
    /*for (int i = size - 1; i > index ; i--) {
      elementData[i] = elementData[i - 1];
    }*/
    System.arraycopy(elementData, index, elementData, index + 1, size - index);
    elementData[index] = e;
    size++;
  }

  @Override
  public E remove(final int index) {
    rangeCheck(index);
    final E oldValue = elementData(index);
    fastRemove(index);
    return oldValue;
  }

  @Override
  public boolean remove(final Object o) {
    if (o == null) {
      for (int i = 0; i < size; i++) {
        if (elementData[i] == null) {
          fastRemove(i);
          return true;
        }
      }
    } else {
      for (int i = 0; i < size; i++) {
        if (o.equals(elementData[i])) {
          fastRemove(i);
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public void clear() {
    modCount++;
    for (int i = 0; i < size; i++) {
      elementData[i] = null;
    }
    size = 0;
  }

  private void fastRemove(final int index) {
    modCount++;
    final int numMoved = size - index - 1;
    if (numMoved > 0) {
      // 使用 System.arraycopy() 方法将 index 位置之后的元素都向前移动一位
      // 等价于倒序遍历，使用后一个元素的值覆盖当前元素，直至 index 位置为止
      /*for (int i = size - 1; i > index; i--) {
        elementData[i - 1] = elementData[i];
      }*/
      System.arraycopy(elementData, index + 1, elementData, index, numMoved);
    }
    elementData[--size] = null;
  }

  private void rangeCheckForAdd(final int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException(outOfBoundMsg(index));
    }
  }

  private void ensureCapacityInternal(final int minCapacity) {
    ensureExplicitCapacity(calculateCapacity(minCapacity));
  }

  private void ensureExplicitCapacity(final int minCapacity) {
    modCount++;
    // 如果所需的最小容量 > 数组长度，则进行扩容
    if (minCapacity - elementData.length > 0) {
      grow(minCapacity);
    }
  }

  private void grow(final int minCapacity) {
    final int oldCapacity = elementData.length;
    // 新容量 = 旧容量 + (旧容量 >> 1) = 旧容量 + (旧容量 / 2) = 旧容量 * 1.5
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    if (newCapacity - minCapacity < 0) {
      newCapacity = minCapacity;
    }
    if (newCapacity - Integer.MAX_VALUE > 0) {
      newCapacity = hugeCapacity(minCapacity);
    }
    // 使用 Arrays.copyOf() 方法创建一个新的数组，容量为 newCapacity，并且将原数组中的所有元素全部拷贝到新数组中
    elementData = Arrays.copyOf(elementData, newCapacity);
  }

  private int hugeCapacity(final int minCapacity) {
    if (minCapacity < 0) {
      throw new OutOfMemoryError();
    }
    return minCapacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
  }

  private int calculateCapacity(final int minCapacity) {
    // 如果使用无参构造函数进行初始化，则 elementData 被赋值为 DEFAULTCAPACITY_EMPTY_ELEMENTDATA
    // 当第一次添加元素时，数组容量会扩容至 DEFAULT_CAPACITY = 10，因此此处需要进行判断 所需的最小容量与 DEFAULT_CAPACITY 哪个比较大
    if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
      return Math.max(DEFAULT_CAPACITY, minCapacity);
    }
    return minCapacity;
  }

  @SuppressWarnings("unchecked")
  private E elementData(final int index) {
    return (E) elementData[index];
  }

  private void rangeCheck(final int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(outOfBoundMsg(index));
    }
  }

  private String outOfBoundMsg(final int index) {
    return "Index: " + index + ", Size: " + size;
  }

  @Override
  public Iterator<E> iterator() {
    return new Itr();
  }

  @Override
  public String toString() {
    final Iterator<E> iterator = new Itr();
    if (!iterator.hasNext()) {
      return "[]";
    }
    final StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (; ; ) {
      final E e = iterator.next();
      // 如果当前元素是当前集合，则将其替换为 "(this Collection)"，这样可以防止死循环
      sb.append(e == this ? "(this Collection)" : e);
      if (!iterator.hasNext()) {
        return sb.append(']').toString();
      }
      sb.append(',').append(' ');
    }
  }

  private class Itr implements Iterator<E> {
    /**
     * 游标，用于记录当前迭代到的元素索引
     */
    int cursor;
    /**
     * 上次迭代时返回的元素索引
     */
    int lastRet = -1;
    /**
     * ArrayList 针对并发修改时，采用快速失败机制 fail-fast，只要 modCount 不等于 expectedModCount，说明在迭代期间集合结构已经发生了改变，如执行了添加或删除元素等操作，
     * 则会立即抛出 ConcurrentModificationException 异常，从而保证集合的迭代安全。
     */
    int expectedModCount = modCount;

    @Override
    public boolean hasNext() {
      return cursor != size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E next() {
      checkForModification();
      int i = cursor;
      if (i >= size) {
        throw new NoSuchElementException();
      }
      final Object[] elementData = ArrayList.this.elementData;
      if (i >= elementData.length) {
        throw new ConcurrentModificationException();
      }
      cursor = i + 1;
      return (E) elementData[lastRet = i];
    }

    @Override
    public void remove() {
      // lastRet 记录了上次迭代时返回的元素索引，如果为 -1，则说明没有调用过 next() 方法，则抛出异常
      // 只有在调用过一次 next() 方法后才能调用一次 remove() 方法，否则抛出异常
      if (lastRet < 0) {
        throw new IllegalStateException();
      }
      checkForModification();
      try {
        ArrayList.this.remove(lastRet);
        cursor = lastRet;
        lastRet = -1;
        expectedModCount = modCount;
      } catch (IndexOutOfBoundsException e) {
        throw new ConcurrentModificationException();
      }
    }

    private void checkForModification() {
      if (expectedModCount != modCount) {
        throw new ConcurrentModificationException();
      }
    }
  }
}
