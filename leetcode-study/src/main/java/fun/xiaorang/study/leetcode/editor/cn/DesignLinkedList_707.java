package fun.xiaorang.study.leetcode.editor.cn;

/**
 * @author liulei
 * @description <a href="https://leetcode.cn/problems/design-linked-list/" style="font-weight:bold;font-size:11px;">707.设计链表<a/>
 * @github <a href="https://github.com/xihuanxiaorang/java-study">java-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025-08-20 22:54:03
 */
@SuppressWarnings({"all"})
public class DesignLinkedList_707 {
  public static void main(String[] args) {
    final MyLinkedList myLinkedList = new DesignLinkedList_707().new MyLinkedList();
    myLinkedList.addAtHead(1);
    myLinkedList.addAtTail(3);
    myLinkedList.addAtIndex(1, 2); // 链表变为 1->2->3
    myLinkedList.get(1); // 返回 2
    myLinkedList.deleteAtIndex(1); // 现在，链表变为 1->3
    myLinkedList.get(1); // 返回 3
    System.out.println(myLinkedList);
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class MyLinkedList {
    // 虚拟头节点（不存储有效数据）
    private ListNode dummyHead;
    // 虚拟尾节点（不存储有效数据）
    private ListNode dummyTail;
    // 链表元素个数（不含虚拟头尾节点）
    private int size;

    public MyLinkedList() {
      dummyHead = new ListNode(-1);
      dummyTail = new ListNode(-1);
      dummyHead.next = dummyTail;
      dummyTail.prev = dummyHead;
    }

    /**
     * 获取链表中指定索引位置的节点值
     *
     * @param index 目标索引（0 <= index < size）
     * @return 如果索引合法，返回对应节点的值；否则返回 -1
     */
    public int get(int index) {
      // 1. 校验索引范围：若 index < 0 或 index >= size，说明越界
      if (index < 0 || index >= size) return -1;
      // 2. 定位到指定索引位置的节点并返回节点存储的值
      return node(index).val;
    }

    /**
     * 在链表头部插入一个新节点
     *
     * @param val 新节点的值
     */
    public void addAtHead(int val) {
      addAtIndex(0, val);
    }

    /**
     * 在链表尾部插入一个新节点
     *
     * @param val 新节点的值
     */
    public void addAtTail(int val) {
      addAtIndex(size, val);
    }

    /**
     * 在链表指定位置前插入一个新节点
     *
     * @param index 插入位置索引，范围 [0, size]
     * @param val   新节点的值
     * @return 无返回值
     *
     * <p>说明：
     * <ul>
     *   <li>{@code index = 0}     → 在头部插入；</li>
     *   <li>{@code index = size}  → 在尾部插入；</li>
     *   <li>{@code index < 0} 或 {@code index > size} → 操作无效，直接返回。</li>
     * </ul>
     */
    public void addAtIndex(int index, int val) {
      // 1. 校验索引范围：若 index 不在 [0, size] 之间，直接返回，不做任何操作
      if (index < 0 || index > size) return;
      // 2. 确定插入位置的前驱节点 pred：
      // 若 index == size，说明在链表尾部插入，新节点的前驱节点应是 dummyTail.prev
      // 否则，找到目标位置的节点，再取它的前驱节点作为 pred
      ListNode pred = index == size ? dummyTail.prev : node(index).prev;
      // 3. 确定插入位置的后继节点 succ，即 pred 的后继节点
      ListNode succ = pred.next;
      // 4. 创建新节点并建立前驱、后继指针关系
      ListNode newNode = new ListNode(pred, val, succ);
      succ.prev = newNode;
      pred.next = newNode;
      // 5. 更新链表长度
      size++;
    }

    /**
     * 删除链表中指定索引位置的节点
     *
     * @param index 要删除的节点索引，范围 [0, size - 1]
     * @return 无返回值
     *
     * <p>说明：
     * <ul>
     *   <li>{@code index = 0}     → 删除头节点；</li>
     *   <li>{@code 0 < index < size} → 删除中间节点；</li>
     *   <li>{@code index = size - 1} → 删除尾节点；</li>
     *   <li>{@code index < 0} 或 {@code index >= size} → 操作无效，直接返回。</li>
     * </ul>
     */
    public void deleteAtIndex(int index) {
      // 1. 校验索引范围：若 index 不在 [0, size-1] 之间，直接返回
      if (index < 0 || index >= size) return;
      // 2. 找到要删除的目标节点 curr
      ListNode curr = node(index);
      // 3. 断开 curr 节点与前驱、后继的连接
      // 前驱节点的 next 指向 curr 的后继
      // 后继节点的 prev 指向 curr 的前驱
      curr.prev.next = curr.next;
      curr.next.prev = curr.prev;
      // 4. 释放 curr 的前后指针，帮助 GC
      curr.prev = null;
      curr.next = null;
      // 5. 更新链表长度
      size--;
    }

    /**
     * 根据索引定位节点
     *
     * <p> 若 index < size / 2，则从头节点 dummyHead 开始向右遍历，否则从尾节点 dummyTail 开始向左遍历。</p>
     *
     * @param index 节点索引（0 <= index < size）
     * @return 对应位置的节点
     * @throws IndexOutOfBoundsException 如果 index 越界
     */
    private ListNode node(int index) {
      // 检查索引是否越界
      if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      }
      // 如果索引小于链表长度的一半，则从头节点开始向右遍历
      if (index < (size >> 1)) {
        ListNode curr = dummyHead;
        for (int i = 0; i <= index; i++) {
          // 向右移动到下一个节点
          curr = curr.next;
        }
        return curr;
      } else {
        // 否则从尾节点开始向左遍历
        ListNode curr = dummyTail;
        for (int i = size - 1; i >= index; i--) {
          // 向左移动到前一个节点
          curr = curr.prev;
        }
        return curr;
      }
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("[");
      for (ListNode curr = dummyHead.next; curr != dummyTail; curr = curr.next) {
        sb.append(curr.val);
        if (curr.next != dummyTail) sb.append(", ");
      }
      return sb.append("]").toString();
    }

    private class ListNode {
      // 节点存储的值
      private int val;
      // 前驱指针
      private ListNode prev;
      // 后继指针
      private ListNode next;

      public ListNode() {
      }

      public ListNode(final int val) {
        this.val = val;
      }

      public ListNode(final ListNode prev, final int val, final ListNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
      }

      @Override
      public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (ListNode curr = this; curr != null; curr = curr.next) {
          sb.append(curr.val);
          if (curr.next != null) sb.append(", ");
        }
        return sb.append("]").toString();
      }
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}