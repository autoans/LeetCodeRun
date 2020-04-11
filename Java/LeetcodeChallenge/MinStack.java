package LeetcodeChallenge;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
 * @author Katherine
 *
 */
class MinStack {

    /*
     * mainStack keeps track of all the numbers like an usual stack.
     * minStack keeps track of all the smallest number so far in the list.
     * e.g. for a list of number 3,1,2
     * minStack will be 3,1,1
     * */
    Stack minStack = new Stack();
    
    Stack mainStack = new Stack();
    
    /** initialize your data structure here. */
    public MinStack() {
    }
    
    public void push(int x) {
        mainStack.push(x);
        if (minStack.isEmpty())
            minStack.push(x);
        else {
            minStack.push(Math.min(x, (int)minStack.peek()));
        }
    }
    
    public void pop() {
        mainStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return (int)mainStack.peek();
    }
    
    public int getMin() {
        return (int)minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
