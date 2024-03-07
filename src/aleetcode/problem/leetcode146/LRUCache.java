package aleetcode.problem.leetcode146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class Node {

        private int data;

        private Node next;

    }

    private Map<Integer, Node> container;

    private Node head;

    private Node tail;

    private int size;

    private int capacity;

    public LRUCache(int capacity) {
        this.container = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {

        int value = container.get(key) != null ? container.get(key).data : -1;



        return value;

    }

    public void put(int key, int value) {

        Node node = new Node();
        node.data = value;

        if (size == capacity) {
            head = head.next;
            tail.next = node;
            tail = node;
        }

        if (head == null) {
            head = node;
            tail = node;
        }

        Node temp = tail;
        tail = node;
        temp.next = tail;

        container.put(key, node);
        size++;
    }
}

