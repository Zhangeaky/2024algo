package aleetcode.problem.leetcode146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class Node {

        public Node(int key, int data) {
            this.key = key;
            this.data = data;
        }

        public Node(int key, int data, Node pre, Node next) {
            this.key = key;
            this.data = data;
            this.next = next;
            this.pre = pre;
        }

        private int key;

        private int data;

        private Node next;

        private Node pre;

    }

    private Map<Integer, Node> container;

    private Node dummyHead;

    private Node dummyTail;

    private int capacity;

    public LRUCache(int capacity) {
        this.container = new HashMap<>();
        this.capacity = capacity;
        initDummy();
    }

    private void initDummy() {
        dummyTail = new Node(-1, -1, null, null);
        dummyHead = new Node(-1, -1, null, dummyTail);
        dummyTail.pre = dummyHead;
    }

    public int get(int key) {
        if (container.get(key) == null) {
            return -1;
        } else {
            // 存在的话 拿出来 并放到队列的最前面
            Node node = container.get(key);
            int value = node.data;
            putNodeToFirst(node);
            return value;
        }
    }

    public void put(int key, int value) {

        // 构建node
        Node node = new Node(key, value, null, null);

        // key 存在
        if (container.containsKey(key)) {
            // 替换原来的node
            Node originNode = container.get(key);
            removeNode(originNode);
            container.put(key, node);
            // value 放到最头部
            putNodeToFirst(node);
        } else {
            // key不存在 且满了
            if (container.size() == capacity) {
                // 一处最后一个元素
                removeTail();
                // 插入元素
                container.put(key, node);
                // value 放到头部
                putNodeToFirst(node);
            } else {
                // 插入元素
                container.put(key, node);
                // value 放到头部
                putNodeToFirst(node);
            }
        }


    }

    private void removeTail() {

        Node originTail = dummyTail.pre;
        if (originTail.data == -1) {
            return;
        }

        Node tailPre = originTail.pre;
        tailPre.next = dummyTail;
        dummyTail.pre = tailPre;

        container.remove(originTail.key);
    }

    private void putNodeToFirst(Node node) {

        Node preNode = node.pre;
        Node nexNode = node.next;
        preNode.next = nexNode;
        nexNode.pre = preNode;

        Node originHead = dummyHead.next;
        dummyHead.next = node;
        node.pre = dummyHead;
        node.next = originHead;
        originHead.pre = node;
    }

    private String toStringContainer() {

        Node curr = dummyHead;
        StringBuilder string = new StringBuilder();
        while (curr!=null) {
            if (curr.data == -1) {
                curr = curr.next;
                continue;
            }
            string.append(" " + curr.data);
            curr = curr.next;
        }
        return string.toString();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);

        cache.put(1 ,1);
        cache.put(2 ,2);
        System.out.println(cache.get(1));


        System.out.println(cache.toStringContainer());
    }

    private void removeNode(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
    }
 }

