package aleetcode.ds.stack;

import java.util.Arrays;

/**
 * 使用数组实现栈
 */
public class StackByArray<E> {

    private E[] data;

    private int topIndex;

    public StackByArray(int capacity) {
        this.data = (E[])new Object[capacity];
        this.topIndex = 0;
    }

    public boolean push(E input) {

        // 如果栈内元素已经满了
        if (isFull()) {
            return false;
        }

        data[topIndex] = input;
        topIndex++;
        return true;
    }

    public E pop() {

        if (isEmpty()) {
            return null;
        }

        // 这里怎么处理？
        if (topIndex == 0) {
            return data[0];
        }

        E poppedObject = data[topIndex-1];
        topIndex--;
        return poppedObject;
    }

    private boolean isFull() {
        return topIndex == data.length;
    }

    private boolean isEmpty() {
        return 0 == data.length ;
    }

    public static void main(String[] args) {
        StackByArray<String> stack = new StackByArray<>(5);

        System.out.println(stack.push("a"));
        System.out.println(stack.push("b"));
        System.out.println(stack.push("c"));
        System.out.println(stack.push("d"));
        System.out.println(stack.push("e"));
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push("mike");
        System.out.println(stack.pop());

        System.out.println("===== =====");
        StackByArray ss = new StackByArray(5);
        System.out.println(ss.pop());
        System.out.println(ss.push("liqinag"));
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());


    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
