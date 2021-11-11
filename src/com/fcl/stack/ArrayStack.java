package com.fcl.stack;

public class ArrayStack {
	private int maxSize;
	private int top = -1;
	private int arrayStack[];
	
	
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		this.arrayStack = new int[maxSize];
	}
	
	public boolean isFull() {
		return top == maxSize - 1;
	}
	
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	
	//入栈
	public void push(int value) {
		if (isFull()) {
			System.out.println("the stack is full");
			return;
		}
		top++;
		arrayStack[top] = value;
	}
	
	
	//出栈
	public void pop() {
		if (isEmpty()) {
			System.out.println("the stack is empty");
			return;
		}
		int value = arrayStack[top];
		top--;
		System.out.println(value);
	}
	
	
	public void showArrayStack() {
		if (isEmpty()) {
			System.out.println("the stack is empty");
			return;
		}
		for (int i = top; i >= 0; i--) {
			System.out.println(arrayStack[i]);
		}
	}
	
}
