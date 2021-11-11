package com.fcl.stack;

import java.util.Stack;

/**
 * 用链表实现栈
 * 可以使用头插法实现，将新加入的数据放在链表的头部
 * 后续遍历也只要从头开始遍历就行，不需要进行逆序输出
 * 如果硬要用尾插法 可以使用双向链表 但是实现过于复杂 性价比不符，故用头插法是最好的选择
 * 
 * 以下实现的是为尾插法，不推荐使用
 * 我就是个傻子
 * @author FCL
 *
 */


public class SingleLinkStack {
	private Node head = new Node(-1);
	private Node top = head;
	
	public boolean isEmpty() {
		return head.next == null;
	}
	
	public void push(int value) {
		Node node = new Node(value);
		top.next = node;
		top = node;
	}
	
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("the stack is empty");
		}
		Node temp = head;
		//找到top的前一个节点
		while(true) {
			if (temp.next == top) {
				break;
			}
			temp = temp.next;
		}
		int v = top.value;
		top = temp;
		top.next = null;
		return v;
	}
	
	public void showStack() {
		if (isEmpty()) {
			System.out.println("the stack is empty");
			return;
		}
		Stack<Integer> stack = new Stack<Integer>();
		Node temp = head.next;
		while(temp != null) {
			stack.push(temp.value);
			temp = temp.next;
		}
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
	
}


class Node{
	public int value;
	public Node next;
	
	public Node(int value) {
		super();
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
}