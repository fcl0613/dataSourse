package com.fcl.circlelinkedlist;

public class Text {

	public static void main(String[] args) {
		CircleLinkedList circleLinkedList = new CircleLinkedList();
		circleLinkedList.createCircleLinkedList(125);
		circleLinkedList.showList();
		System.out.println();
		circleLinkedList.countChild(10, 20, 125);
	}

}
