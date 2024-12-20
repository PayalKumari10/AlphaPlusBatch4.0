// leetcode 160


public class Solution {
    public ListNode findStartingPointofCycle(ListNode head){
        if(head==null || head.next== null){
            return null;
        }

        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while(slow != fast && fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // there is no cycle, no intersection point
        if(slow != fast) return null;
        
        slow = head;
        // now move by same speed
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        ListNode temp = headA;

        while(temp.next != null){
            temp = temp.next;
        }

        // temp is at tail
        temp.next = headB;

        ListNode ans = findStartingPointofCycle(headA);

        // fixing the LL again;
        temp.next = null;

        return ans;
    }
}


