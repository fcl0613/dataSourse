package com.fcl.stack.practicebook;

public class LinkStack {
	private Node head = new Node();
	private Node top = head.next;
	
	public boolean isEmpty() {
		return head.next == null;
	}
	
	public Object peek() {
		if (isEmpty()) {
			return null;
		}else {
			return top.data;
		}
	}
	
	public Object pop() {
		if (isEmpty()) {
			throw new RuntimeException("the stack is empty");
		}
		Node temp = top;
		head.next = top.next;
		top = top.next;
		return temp.data;
	}
	
	public void push(Object o) {
		Node node = new Node(o);
		node.next = top;
		head.next = node;
		top = node;
	}
	
	public void showStack() {
		if (isEmpty()) {
			System.out.println("the stack is empty");
			return;
		}
		Node temp = top;
		while(temp != null) {
			System.out.print(temp.data.toString()+ " ");
			temp = temp.next;
		}
		System.out.println();
	}
}

class Node{
	public Object data;
	public Node next;
	
	public Node(Object data) {
		this.data = data;
	}
	
	public Node() {
		this.data = null;
		this.next = null;
	}
}
