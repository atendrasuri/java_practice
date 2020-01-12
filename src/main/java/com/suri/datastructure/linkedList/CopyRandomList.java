package com.suri.datastructure.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 * The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
 *
 *
 * Example 1:
 *
 *
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * Return a deep copy of the list.
 */
public class CopyRandomList {

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int val) {
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

    /** second apprroach **/

    public Node copyRandomList(Node head) {

        if(head==null){
            return null;
        }

        Node curr = head;

        Map<Node, Node> map = new HashMap<>();

        while(curr!=null){

            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;

        while(curr!=null){

            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);

    }
}
