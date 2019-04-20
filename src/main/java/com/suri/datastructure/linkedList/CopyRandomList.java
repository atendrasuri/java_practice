package com.suri.datastructure.linkedList;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 20/04/19
 * @Description: (Overwrite)
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 */
public class CopyRandomList {

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }


        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            Node prev = new Node(0, null, null);
            Node res = prev;
            while (head != null) {
                Node curr = new Node(head.val, null, head.random);
                head.random = curr;
                prev.next = curr;
                prev = prev.next;
                head = head.next;
            }
            prev = res.next;
            while (prev != null) {
                if (prev.random != null)
                    prev.random = prev.random.random;
                prev = prev.next;
            }
            return res.next;
        }
    }
}
