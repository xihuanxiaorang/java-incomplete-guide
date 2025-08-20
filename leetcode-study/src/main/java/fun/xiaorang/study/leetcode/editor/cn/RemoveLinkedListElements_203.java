package fun.xiaorang.study.leetcode.editor.cn;

/**
 * @author liulei
 * @description <a href="https://leetcode.cn/problems/remove-linked-list-elements/" style="font-weight:bold;font-size:11px;">203.移除链表元素<a/>
 * @github <a href="https://github.com/xihuanxiaorang/java-study">java-study</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让の码场</a>  - show me the code
 * @date 2025-08-19 23:08:06
 */
@SuppressWarnings({"all"})
public class RemoveLinkedListElements_203 {
  public static void main(String[] args) {
    final Solution solution = new RemoveLinkedListElements_203().new Solution();
    final int[] nums = new int[]{1, 2, 6, 3, 4, 5, 6};
    final int val = 6;
    final ListNode head = solution.removeElements(buildList(nums), val);
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
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("[");
      ListNode curr = this;
      for (; ; ) {
        sb.append(curr.val);
        if (curr.next == null) {
          return sb.append("]").toString();
        }
        curr = curr.next;
        sb.append(",").append(" ");
      }
    }
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public ListNode removeElements(ListNode head, int val) {
      // 1. 初始化虚拟头节点 dummy，其 next 指向头节点 head
      final ListNode dummy = new ListNode(-1, head);
      // 2. 定义指针 curr 指向虚拟头节点 dummy，从虚拟头节点开始遍历链表
      ListNode curr = dummy;
      // 3. 遍历链表并删除目标节点，直至 curr.next 为 null
      while (curr.next != null) {
        if (curr.next.val == val) {
          // 3.1 如果下一个节点的值等于 val，则删除该节点，即让 curr.next 指向 curr.next.next
          curr.next = curr.next.next;
        } else {
          // 3.2 否则，将 curr 向后移动，继续遍历
          curr = curr.next;
        }
      }
      // 返回处理后的链表头节点
      return dummy.next;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}