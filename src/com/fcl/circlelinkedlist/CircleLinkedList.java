package com.fcl.circlelinkedlist;

/**
 * Josepfu 问题
 * 
 * @author FCL
 *
 */

public class CircleLinkedList {
	private Child first = null;

	
	public void countChild(int startNum, int countNum, int nums) {
		if (first == null || startNum < 1 || countNum > nums) {
			System.out.println("the param is not right");
			return;
		}
		Child heaper = first;
		//让heaper指向first的后一个节点
		while(true) {
			if (heaper.next == first) {
				break;
			}
			heaper = heaper.next;
		}
		//初始化  从第n个数起
		for (int i = 0; i < startNum-1; i++) {
			first = first.next;
			heaper = heaper.next;
		}
		//出循环链表
		while(true) {
			if (heaper == first) {
				System.out.println(heaper.no);
				break;
			}
			for (int i = 0; i < countNum-1; i++) {
				first = first.next;
				heaper = heaper.next;
			}
			System.out.println(first.no);
			first = first.next;
			heaper.next = first;
		}
	}
	
	
	public void createCircleLinkedList(int num) {
		if (num < 1) {
			System.out.println("this number is invalid");
			return;
		}
		Child curr = null;
		for (int i = 1; i <= num; i++) {
			if (first == null) {
				first = new Child(i);
				curr = first;
			}else {
				Child child = new Child(i);
				child.next = curr.next;
				curr.next = child;
				curr = curr.next;
			}
		}
		curr.next = first;
	}
	
	
	public void showList() {
		if (first == null) {
			System.out.println("this list is null");
			return;
		}
		Child c = first;
		while(c != null) {
			System.out.println(c.no);
			if (c.next == first) {
				break;
			}
			c = c.next;
		}
	}

}

class Child {
	public int no;
	public Child next;

	public Child(int no) {
		this.no = no;
	}
}
