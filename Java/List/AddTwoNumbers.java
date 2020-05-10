package List;

/**
 * 2. Add Two Numbers
 * 
 * @author https://zxi.mytechroad.com/blog/simulation/leetcode-2-add-two-numbers-2/
 *
 */
public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tail = new ListNode(-1);
        ListNode dummy = tail;

        int sum = 0;
        while (l1.next != null || l2.next != null || sum > 0) {
            sum += (l1 == null? 0: l1.val) + (l2 == null? 0 : l2.val);
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            sum = sum/10; // carry over to the next digit
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        return dummy.next;
    }
}
