package fun.xiaorang.study.leetcode.editor.cn;

/**
 * @author liulei
 * @description <a href="https://leetcode.cn/problems/linked-list-cycle-ii/" style="font-weight:bold;font-size:11px;">142.环形链表 II<a/>
 * @github <a href="https://github.com/xihuanxiaorang/java-study">java-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025-08-27 23:16:06
 */
@SuppressWarnings({"all"})
public class LinkedListCycleIi_142 {
  public static void main(String[] args) {
    final Solution solution = new LinkedListCycleIi_142().new Solution();
    final int[] nums = new int[]{3, 2, 0, -4};
    int pos = 1;
    final ListNode head = solution.detectCycle(buildCycleList(nums, pos));
    System.out.println(head.val);
  }

  public static ListNode buildCycleList(int[] nums, int pos) {
    if (nums == null || nums.length == 0) return null;
    ListNode dummy = new ListNode(-1), curr = dummy;
    ListNode cycleNode = null;
    for (int i = 0; i < nums.length; i++) {
      final ListNode newNode = new ListNode(nums[i]);
      if (i == pos) cycleNode = newNode;
      if (i == nums.length - 1) newNode.next = cycleNode;
      curr.next = newNode;
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
        System.out.println(curr.val);
        sb.append(curr.val);
        if (curr.next != null) sb.append(", ");
      }
      return sb.append("]").toString();
    }
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  public class Solution {
    /**
     * 检测链表中是否存在环，并返回环的起始节点。
     *
     * @param head 链表头节点
     * @return 环的起始节点，如果不存在环则返回 null
     */
    public ListNode detectCycle(ListNode head) {
      // 初始化两个指针：慢指针 slow 和快指针 fast，都指向链表头节点
      ListNode slow = head, fast = head;
      // 当快指针 fast 及其下一个节点不为空时循环
      while (fast != null && fast.next != null) {
        // 快指针每次移动两步
        fast = fast.next.next;
        // 慢指针每次移动一步
        slow = slow.next;
        // 如果快指针和慢指针相遇，说明链表中存在环
        if (fast == slow) {
          // 初始化一个新的指针 p，从链表头节点开始
          ListNode p = head;
          // 移动 p 和 slow 直到它们相遇，相遇点即为环的起始节点
          while (p != slow) {
            p = p.next;  // 移动 p 指针
            slow = slow.next;  // 移动 slow 指针
          }
          // 返回环的起始节点
          return p;
        }
      }
      // 如果遍历完整个链表都没有发现环，则返回 null
      return null;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}