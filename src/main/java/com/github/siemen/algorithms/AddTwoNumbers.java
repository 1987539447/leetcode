/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */
package com.github.siemen.algorithms;

import java.util.List;

/**
 * 非负整数
 * 以链表的形式存储整数-从低到高位，输出两整数相加结果链表
 *
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers add = new AddTwoNumbers();
        ListNode l1 = add.initListNode(2, 4, 3);
        ListNode l2 = add.initListNode(5, 6, 4);
        ListNode sum = add.addTwoNumbers(l1, l2);
        print(l1);
        print(l2);
        print(sum);
    }

    private static void print(ListNode sum) {
        ListNode cur = sum;
        while (cur != null){
            System.out.print(cur.val);
            if(cur.next != null){
                System.out.print("--->");
            }
            cur = cur.next;
        }
        System.out.println();
    }

    private  ListNode initListNode(int...numbers) {
        ListNode head = new ListNode(numbers[0]);
        ListNode cur = head;
        for (int i = 1; i < numbers.length; i++) {
            cur.next = new ListNode(numbers[i]);
            cur = cur.next;
        }
        return head;
    }

    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dumpHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, cur = dumpHead;
        int carry = 0;
        while (p1 != null || p2 != null) {
           int x = p1 == null ? 0 : p1.val;
           int y = p2 == null ? 0 : p2.val;
           int sum = carry + x + y;
           carry = sum / 10;
           cur.next = new ListNode(sum % 10);
           cur = cur.next;
           if(p1 != null) {
               p1 = p1.next;
           }
           if(p2 != null){
               p2 = p2.next;
           }
        }
        if(carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dumpHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


}