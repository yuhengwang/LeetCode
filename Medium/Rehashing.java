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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        ArrayList<Integer> elements = new ArrayList<>();
        int capacity = hashTable.length * 2;
        for (int i = 0; i < hashTable.length; i++) {
            ListNode cur = hashTable[i];
            while (cur != null) {
                elements.add(cur.val);
                cur = cur.next;
            }
        }
        ListNode[] result = new ListNode[capacity];
        for (int num : elements) {
            int index = hashcode(num, capacity);
        //    System.out.println(index);
          
            ListNode temp = new ListNode(num);
            if (result[index] == null) {
                result[index] = new ListNode(temp.val);
            } else {
                ListNode dummy = result[index];
                while (dummy.next != null) {
                    dummy = dummy.next;
                }
                dummy.next = temp;
            }
        }
        return result;
        
    }
    private int hashcode(int key, int capacity) {
        while (key < 0) {
            key += capacity;
        }
        return key % capacity;
    }
};
