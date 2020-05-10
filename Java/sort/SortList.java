package sort;

/**
 * 148. Sort List
 * 
 * @author penzh
 *
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        // Step1: Get the head of the list and head of the middle of the list
        ListNode slow = head; // slow will be the head of the middle of the list
        ListNode fast = head;
        ListNode pre = null;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        
        pre.next = null;
        
        // Step 2: sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        // Step 3: merge
        return mergeTwoLists(l1, l2);
    }
    
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode prehead = new ListNode(-1);
        ListNode pre = prehead;
        while (head1 != null || head2 != null) {
            if ((head1 != null && head2 != null && head1.val < head2.val) || (head1 != null && head2 == null)) {
                prehead.next = new ListNode(head1.val);
                head1 = head1.next;
            } else {
                prehead.next = new ListNode(head2.val);
                head2 = head2.next;
            }
            
            prehead = prehead.next;
        }
        
        return pre.next;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        
        SortList sl = new SortList();
        ListNode headsorted = sl.sortList(head);
        
        while(headsorted!= null) {
            System.out.print(headsorted.val + "->");
            headsorted = headsorted.next;
        }
    }
}
