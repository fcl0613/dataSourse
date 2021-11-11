package com.fcl.stack.practicebook;

public class SqStack {
	private Object[] stack;
	private int top;
	
	public SqStack(int maxSize) {
		top = -1;
		stack = new Object[maxSize];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public Object peek() {
		if (isEmpty()) {
			return null;
		}else {
			return stack[top];
		}
	}
	
	public Object pop() {
		if (isEmpty()) {
			throw new RuntimeException("the stack is empty");
		}
		Object o = stack[top];
		top--;
		return o;
	}
	
	public void push(Object o) {
		if (top == (stack.length - 1)) {
			throw new RuntimeException("the stack is full");
		}
		top++;
		stack[top] = o;
	}
	
	public void showStack() {
		if (isEmpty()) {
			System.out.println("the stack is empty");
			return;
		}
		for (int i = top; i >=0; i--) {
			System.out.print(stack[i].toString()+" ");
		}
	}
}
