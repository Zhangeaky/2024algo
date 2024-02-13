package aproblem;


/**
 * 实现使用环形数组实现队列
 * @param <E>
 * 1. 环形的数组如何计算游标移动后的指针值
 */
public class MyQueue<E>{

    private final static int DEFAULT_CAPACITY = 16;

    private E[] data;

    private int n;

    private int head;

    private int tail;

    public MyQueue() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
        this.n = DEFAULT_CAPACITY;
    }

    public boolean enqueue(E input) {

        if (isFull()) {
            return false;
        }
        data[tail] = input;
        // tail++ 这里为什么不能使用tail ++
        tail = (tail+1) % n;
        return true;
    }

    public E dequeue() {

        if (isEmpty()) {
            return null;
        }

        E value = data[head];
        //head--;
        head = (head + 1) % n;
        return value;
    }

    private boolean isFull() {
        return (tail + 1) % n == head;
    }

    private boolean isEmpty() {
        return tail == head;
    }

    public static void main(String[] args) {

        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }

}
