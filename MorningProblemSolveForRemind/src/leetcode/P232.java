package leetcode;

import java.util.Stack;
import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/implement-queue-using-stacks/">
 * 232. Implement Queue using Stacks
 * </a>
 * Created by Kwon Youngwoo on 2019.06.14 10:48
 */
public class P232 {

  class MyQueue {

    private Stack<Integer> stack;
    private Stack<Integer> reverseStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
      stack = new Stack<>();
      reverseStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
      stack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
      while (!stack.empty()) {
        reverseStack.push(stack.pop());
      }

      int popValue = reverseStack.pop();

      while (!reverseStack.empty()) {
        stack.push(reverseStack.pop());
      }

      return popValue;
    }

    /**
     * Get the front element.
     */
    public int peek() {
      while (!stack.empty()) {
        reverseStack.push(stack.pop());
      }

      int peekValue = reverseStack.peek();

      while (!reverseStack.empty()) {
        stack.push(reverseStack.pop());
      }

      return peekValue;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
      return stack.empty();
    }
  }

  /*
   * Your MyQueue object will be instantiated and called as such:
   * MyQueue obj = new MyQueue();
   * obj.push(x);
   * int param_2 = obj.pop();
   * int param_3 = obj.peek();
   * boolean param_4 = obj.empty();
   */

  @Test
  public void testMyQueue() {
    MyQueue myQueue = new MyQueue();
    myQueue.push(1);
    myQueue.push(2);
    myQueue.push(3);
    Assert.assertEquals(Integer.valueOf(1), Integer.valueOf(myQueue.pop()));
    Assert.assertEquals(Integer.valueOf(2), Integer.valueOf(myQueue.peek()));
    Assert.assertEquals(Integer.valueOf(2), Integer.valueOf(myQueue.pop()));
    Assert.assertEquals(Integer.valueOf(3), Integer.valueOf(myQueue.pop()));
    Assert.assertTrue(myQueue.empty());
  }
}
