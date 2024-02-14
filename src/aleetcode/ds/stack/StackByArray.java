package aleetcode.ds.stack;

import java.util.Arrays;

/**
 * 使用数组实现栈
 * 错误原因一: 题目做的少，受到以前做过的题目的影响 搞了一个什么栈顶指针,没有考虑全面栈顶指针为0的情况
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
        if (topIndex == 1) {
            E popped = data[0];
            data[0] = null;
            topIndex--;
            return popped;
        }

        E poppedObject = data[topIndex-1];
        topIndex--;
        return poppedObject;
    }

    private boolean isFull() {
        return topIndex == data.length;
    }

    private boolean isEmpty() {
        // TODO: 2024/2/14 离了大普 数组的length 没有理解清楚
        return 0 == data.length ;
    }

    public static void main(String[] args) {
        StackByArray<String> stack = new StackByArray<>(5);

        System.out.println(stack.push("one"));
        System.out.println(stack.push("two"));
        System.out.println(stack.push("three"));
        System.out.println(stack.push("four"));

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());


    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
