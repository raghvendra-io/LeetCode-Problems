/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int k) {
        if(head == null) return null;
       
        int cnt = 0;
        ListNode temp = head;
        while(temp != null){
            cnt++;
            temp = temp.next;

        }

        if(cnt == k){
            return head.next;
        }

        int res = cnt-k;
        temp = head;

    

    while(temp != null){
        res--;
        if(res==0){
            break;

        }

        temp = temp.next;

    }
    temp.next = temp.next.next;
    return head;
    }
}

