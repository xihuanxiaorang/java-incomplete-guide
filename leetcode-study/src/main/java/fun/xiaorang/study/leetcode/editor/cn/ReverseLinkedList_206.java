package fun.xiaorang.study.leetcode.editor.cn;

/**
 * @author liulei
 * @description <a href="https://leetcode.cn/problems/reverse-linked-list/" style="font-weight:bold;font-size:11px;">206.反转链表<a/>
 * @github <a href="https://github.com/xihuanxiaorang/java-study">java-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025-08-24 21:49:01
 */
@SuppressWarnings({"all"})
public class ReverseLinkedList_206 {
  public static void main(String[] args) {
    final Solution solution = new ReverseLinkedList_206().new Solution();
    final int[] nums = new int[]{1, 2, 3, 4, 5};
    final ListNode head = solution.reverseList(buildList(nums));
    System.out.println(head);
  }

  public static ListNode buildList(int... nums) {
    if (nums == null || nums.length == 0) return null;
    ListNode dummy = new ListNode(0), curr = dummy;
    for (int num : nums) {
      curr.next = new ListNode(num);
      curr = curr.next;
    }
    return dummy.next;
  }

  private static class ListNode {
    // 节点存储的值
    private int val;
    // 后继指针
    private ListNode next;

    public ListNode() {
    }

    public ListNode(final int val) {
      this.val = val;
    }

    public ListNode(final int val, final ListNode next) {
      this.val = val;
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

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    /**
     * 反转链表
     *
     * @param head 链表头节点
     * @return 反转后的链表头节点
     */
    public ListNode reverseList(ListNode head) {
      // 初始化前一个节点为 null，当前节点为头节点
      ListNode pre = null, curr = head;
      // 当当前节点不为空时循环
      while (curr != null) {
        // 暂存当前节点的下一个节点
        ListNode next = curr.next;
        // 将当前节点指向前一个节点，实现反转
        curr.next = pre;
        // 移动 pre 和 curr 指针，pre 向前移动到 curr，curr 向前移动到 next
        pre = curr;
        curr = next;
      }
      // 返回新的头节点，即原来的尾节点
      return pre;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}