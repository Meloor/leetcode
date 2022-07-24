import java.util.Stack;

/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
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
// todo 看下递归操作, 比开栈省空间
/**
 * hint: 
 *  1 遍历linked-list,
 *  2 遍历,使用栈存储，然后弹栈构建新链表
 *  时间O(n),空间O(n)
 */
class Solution1 {
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> st = new Stack<ListNode>();
        ListNode tail= null;
        ListNode node= null;
        while(head!=null){
            st.push(head);
            head = head.next;
        }
        if(!st.empty()){
            node = st.pop();
            head = node;
            tail = head;
        }
        while(!st.empty()){
            node = st.pop();
            node.next = null;
            tail.next = node;
            tail = node;
        }
        return head;
    }
}
/**
 * hint:题解里的迭代法
 *  1 每次更改curr.next, 反转指向,修改指向前需要保存pre(修改时用),next(移动curr时用),
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre= null;//pre->a
        ListNode curr= head;//curr->b
        ListNode nt= curr==null?null:curr.next;//nt->c
        //curr指向空节点时退出
        while(curr!=null){
            curr.next = pre;//b->a, 每一轮主要做这件事,需要用到pre和next,而自己节点不能保存该信息，所以需要多开两个node来保存
            pre = curr;//pre->b
            curr = nt;//curr->c
            nt = curr==null?null:curr.next;//nt->d
        }
        return pre;
    }
}
// @lc code=end

