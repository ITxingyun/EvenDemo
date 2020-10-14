package com.example.javalib.arithmetic;

import java.util.HashMap;

public class AddTwoNumbers {

    /**
     * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        HashMap<Integer, Integer> node1Map = getMapFromListNode(l1);
        HashMap<Integer, Integer> node2Map = getMapFromListNode(l2);
        HashMap<Integer, Integer> digitMap = new HashMap<>();
        int size = node1Map.size() >= node2Map.size() ? node1Map.size() : node2Map.size();
        ListNode result = null;
        ListNode resultNext = null;
        for (int i = 1; i <= size; i++) {
            int digit = getValue(node1Map, i) + getValue(node2Map, i) + getValue(digitMap, i);
            if (digit >= 10) {
                digitMap.put(i + 1, 1);
            }
            if (i == 1) {
                result = new ListNode(digit % 10);
                resultNext = result;
            } else {
                resultNext.next = new ListNode(digit % 10);
                resultNext = resultNext.next;
            }
        }
        if (digitMap.get(size + 1) != null) {
            resultNext.next = new ListNode(1);
        }
        return result;
    }

    private int getValue(HashMap<Integer, Integer> map, int key) {
        return map.get(key) != null ? map.get(key) : 0;
    }

    private HashMap<Integer, Integer> getMapFromListNode(ListNode listNode) {
        HashMap<Integer, Integer> nodeMap = new HashMap<>();
        int index = 1;
        while (listNode != null) {
            nodeMap.put(index, listNode.val);
            listNode = listNode.next;
            index++;
        }
        return nodeMap;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static int c = 4;

    public static void main(String[] args) {
        int a = c++;
        set();
        System.out.println(a);
    }

    public static void set() {
        c = 2;
    }


}
