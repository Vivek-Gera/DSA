package dsa.apps;

import dsa.structures.stack.Stack;

public class StackApp {
    public static void main(String[] args) {

        Stack stack = new Stack();

        stack.push(100);
        stack.push(90);
        stack.push(80);
        stack.push(70);
        stack.pop();
        stack.push(60);
        stack.push(50);
        stack.push(40);
        stack.push(30);
        stack.push(20);
        stack.push(10);

        stack.print();
        System.out.println();

        System.out.println(stack.peek());
        System.out.println();
        stack.pop();

        System.out.println(stack.peek());
        System.out.println();

        stack.print();


    }
}
