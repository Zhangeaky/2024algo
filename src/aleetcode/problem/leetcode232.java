package aleetcode.problem;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/implement-queue-using-stacks/description/
 */
public class leetcode232 {

    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);

        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());


    }


}

class MyQueue {

    private Stack<Integer> leftStack;

    private Stack<Integer> rightStack;


    public MyQueue() {
        this.leftStack = new Stack<>();
        this.rightStack = new Stack<>();
    }

    public void push(int x) {
        leftStack.push(x);
    }

    public int pop() {

        if (!rightStack.empty()) {
            return rightStack.pop();
        }

        if (!leftStack.empty()) {
            transfer();
        }
        return rightStack.pop();
    }

    public int peek() {
        if (!rightStack.empty()) {
            return rightStack.peek();
        }

        if (!leftStack.empty()) {
           transfer();
        }
        return rightStack.peek();
    }

    public boolean empty() {
        return rightStack.empty() && leftStack.empty();
    }

    private void transfer() {
        for (int i=leftStack.size(); i>0; i--) {
            rightStack.push(leftStack.pop());
        }
    }
}
