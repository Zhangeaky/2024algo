package aleetcode.ds.queue;

public class QueueByLinkedList<T> {

    static class Node<R> {

        R item;

        Node<R> pre;

        Node<R> next;

        public Node(R item, Node<R> pre, Node<R> next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }

    }

    private Node<T> head;

    private Node<T> tail;

    public QueueByLinkedList() {
    }

    public boolean add(T value) {

        Node<T> node = new Node<>(value, null, null);
        if (head == null) {
            head = node;
            tail = node;
        }

        node.pre = tail;
        tail.next = node;
        tail = node;
        return true;
    }

    public T poll() {

        if (head == null) {
            System.out.println("队列为空！");
            return null;
        }

        Node<T> polled = head;
        head = head.next;
        return polled.item;
    }

    public static void main(String[] args) {

        QueueByLinkedList<Integer> queue = new QueueByLinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());





    }

}
