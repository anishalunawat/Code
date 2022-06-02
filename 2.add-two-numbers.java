/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root=null,temp=null;
        int sum=0;
        while(l1!=null && l2!=null) {
            sum+=l1.val +l2.val;
            if(root==null) {
                root = new ListNode(sum%10);
                temp = root;
            }
            else {
                temp.next = new ListNode(sum%10);
                temp=temp.next;
            }
            sum=sum/10;
            l1=l1.next;
            l2=l2.next;
        }
        if(l2!=null)
            l1=l2;
        while(sum!=0 && l1!=null) {
            sum+=l1.val;
            temp.next = new ListNode(sum%10);
            temp=temp.next;
            sum=sum/10;
            l1=l1.next;
        }
        if(sum!=0) {
            temp.next = new ListNode(sum);
        }
        if(l1!=null) {
            temp.next=l1;
        }
        
        return root;
    }
}
// @lc code=end

