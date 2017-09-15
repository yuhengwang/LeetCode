odd index will always be bigger than even index!!! hence we need to consider even is null or even.next is  null
and in the end, we contactnant odd and even together!
  ALWAYS CONSIDER WHETHER WE NEED TO DO END.NEXT = NULL, IN CASE OF MLE

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)   return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenhead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;
    }
}

This method is not optimal, we need to consider many boundary situations

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)   return null;
        //find the end of the linkedList
        ListNode end = head;
        while (end.next != null) {
            end = end.next;
        }
        ListNode endOfNode = end;
        ListNode prev = null;
        ListNode curr = head;
        int index = 1;
        while (curr != null) {
            if (index % 2 == 0) {
            //if curr pointer points to the updated end, we do not need to remove the node and append it again
                if (end == curr) {
                    break;
                }
                //remove curr and append to the end
                ListNode next = curr.next;
                curr.next = null;
                prev.next = next;
                end = appendToEnd(end, curr);
                //if we already move the original end to the back, we can stop the moving operation(when there is even number)
                if (curr == endOfNode)  {
                    break;
                }
                curr = next;
                //if we find the node curr point to now is the original end, we can stop the moving operation
                if (curr == endOfNode)  {
                    break;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
            index++;
        }
        return head;
    }
    public ListNode appendToEnd(ListNode end, ListNode data) {
        end.next = data;
        end = end.next;
        return end;
    }
}
