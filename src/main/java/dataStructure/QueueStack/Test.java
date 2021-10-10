package dataStructure.QueueStack;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        LowerMyQueue q = new LowerMyQueue();
        q.enQueue(5);
        q.enQueue(3);
        if (q.isEmpty() == false) {
            System.out.println(q.Front());
        }
        q.deQueue();
        if (q.isEmpty() == false) {
            System.out.println(q.Front());
        }
        q.deQueue();
        if (q.isEmpty() == false) {
            System.out.println(q.Front());
        }
        
        
         MyCircularQueue obj = new MyCircularQueue(5);
         boolean param_1 = obj.enQueue(3);
         obj.enQueue(2);
         obj.enQueue(1);


         boolean param_2 = obj.deQueue();
         int param_3 = obj.Front();
         int param_4 = obj.Rear();
         boolean param_5 = obj.isEmpty();
         boolean param_6 = obj.isFull();

        ArrayList<Integer> integers = new ArrayList<>();



        // 1. Initialize a queue.
        Queue<Integer> sq = new LinkedList();
        // 2. Get the first element - return null if queue is empty.
        System.out.println("The first element is: " + sq.peek());
        // 3. Push new element.
        sq.offer(5);
        sq.offer(13);
        sq.offer(8);
        sq.offer(6);
        // 4. Pop an element.
        sq.poll();
        // 5. Get the first element.
        System.out.println("The first element is: " + sq.peek());
        // 7. Get the size of the queue.
        System.out.println("The size is: " + sq.size());


        MyStack myStack = new MyStack();
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);

        myStack.pop();
        int top = myStack.top();
        System.out.println(top);


        // 1. Initialize a stack.
        Stack<Integer> s = new Stack<>();
        // 2. Push new element.
        s.push(5);
        s.push(13);
        s.push(8);
        s.push(6);
        // 3. Check if stack is empty.
        if (s.empty() == true) {
            System.out.println("Stack is empty!");
            return;
        }
        // 4. Pop an element.
        s.pop();
        // 5. Get the top element.
        System.out.println("The top element is: " + s.peek());
        // 6. Get the size of the stack.
        System.out.println("The size is: " + s.size());

        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(-1);
        minStack.push(-3);
        minStack.push(1);
        int min = minStack.getMin();
        System.out.println(min);


    }
}
