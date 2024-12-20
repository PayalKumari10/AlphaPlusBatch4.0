// keep m, delete n nodes

public class Solution {
    /**
     * @param head: Head of a linked list.
     * @param m: Nodes to be kept.
     * @param n: Nodes to be deleted.
     * @return: The head of the modified list after removing the mentioned nodes.
     */
    ListNode ogHead;
    ListNode ogTail;
    public void addLast(ListNode curr){
        ogTail.next = curr;
        ogTail = curr;
    }

    public addNodes(ListNode curr, int m){
        while(curr!=null && m>0){
            ListNode currKaNext = curr.next;
            curr.next = null;

            addLast(curr);

            curr = currKaNext;
            m--;
        }

        return curr;
    }

    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);

        ogHead = dummy;
        ogTail = dummy;

        ListNode curr = head;
        int N = n;

        while(curr!= null){
            curr = addNodes(curr,m);

            // delete n nodes
            while(N>0 && curr!=null){
                curr = curr.next;
                N--;
            }
            N=n;
        }

        return dummy.next;
    }
}
