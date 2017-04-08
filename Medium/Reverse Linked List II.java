/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode mPrev = dummy;
        ListNode nPrev = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (m != 1) {
                mPrev = mPrev.next;
                m--;
            }
            if (n != 1) {
                nPrev = nPrev.next;
                n--;
            }
            cur = cur.next;
        }
        ListNode tail = mPrev.next;
        ListNode mNode = mPrev.next;
        ListNode nNode = nPrev.next;
        ListNode nNext = nNode.next;
       // System.out.println(tail.val + "\t" + nNode.val);
        cur = mNode.next;
        while (mNode != nNode) {
         //   System.out.println(mNode.val +"\t" + nNode.val);
            ListNode temp = cur.next;
            cur.next = mNode;
            mNode = cur;
            cur = temp;
        }
        //connect
        tail.next = nNext;
        mPrev.next = mNode;
        
        return dummy.next;
        
        
    }
}

// more brief way
/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        // first find m node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        ListNode preM = head;
        ListNode mNode = head.next; 
        ListNode postnNode = mNode.next;  //cur
        ListNode nNode = mNode; //prev
        for (int i = m; i < n; i++) {
            ListNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }
        // connect
        mNode.next = postnNode;
        preM.next = nNode;
        return dummy.next;
    }
}
