package fun.xiaorang.study.leetcode.editor.cn;

/**
 * @author liulei
 * @description <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/" style="font-weight:bold;font-size:11px;">19.删除链表的倒数第 N 个结点<a/>
 * @github <a href="https://github.com/xihuanxiaorang/java-study">java-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025-08-26 19:06:33
 */
@SuppressWarnings({"all"})
public class RemoveNthNodeFromEndOfList_19 {
  public static void main(String[] args) {
    final Solution solution = new RemoveNthNodeFromEndOfList_19().new Solution();
    final int[] nums = new int[]{1, 2, 3, 4, 5};
    final ListNode head = solution.removeNthFromEnd(buildList(nums), 2);
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
     * 删除链表的倒数第 N 个结点。
     *
     * @param head 链表头节点
     * @param n    要删除的倒数第 n 个结点
     * @return 修改后的链表头节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
      // 创建一个虚拟头节点，其next指向原始链表的头节点。
      // 使用虚拟头节点可以简化边界条件处理，例如当需要删除的是链表的第一个节点时。
      ListNode dummyHead = new ListNode(-1, head);
      // 初始化两个指针，slow和fast。slow从虚拟头节点开始，而fast则从真正的头节点开始。
      // 这样做的目的是让fast先走n步，之后再同时移动slow和fast，直到fast到达链表末尾。
      // 当fast到达链表末尾时，slow正好位于要删除节点的前一个位置。
      ListNode slow = dummyHead, fast = head;
      // 让fast指针先行移动n步。这样做的目的是在fast和slow之间制造出n个节点的距离。
      for (int i = 0; i < n; i++) fast = fast.next;
      // 当fast不为空时，继续移动slow和fast指针。这一步确保了即使链表长度恰好为n，
      // 我们也能正确地找到要删除节点的前一个节点（即slow）。
      while (fast != null) {
        slow = slow.next;  // 移动slow指针
        fast = fast.next;  // 移动fast指针
      }
      // 此时，slow指针正好位于要删除节点的前一个位置。通过将slow的next指针直接跳过下一个节点，
      // 我们就实现了删除目标节点的操作。
      slow.next = slow.next.next;
      // 返回修改后的新链表头节点，即dummyHead的next节点。
      // 注意：这里返回的是dummyHead.next而不是head，因为如果删除的是原链表的第一个节点，则head已不再是新的链表头。
      return dummyHead.next;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}