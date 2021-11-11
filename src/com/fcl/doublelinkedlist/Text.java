package com.fcl.doublelinkedlist;


public class Text {

	public static void main(String[] args) {
		PartnerNode partnerNode1 = new PartnerNode(1,"胡桃");
		PartnerNode partnerNode2 = new PartnerNode(2,"刻晴");
		PartnerNode partnerNode3 = new PartnerNode(3,"甘雨");
		PartnerNode partnerNode4 = new PartnerNode(4,"烟绯");
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//		doubleLinkedList.addAfterHead(partnerNode1);
//		doubleLinkedList.add(partnerNode2);
//		doubleLinkedList.addAfterHead(partnerNode3);
//		doubleLinkedList.addAfterHead(partnerNode4);
//		doubleLinkedList.showList();
//		PartnerNode partnerNode5 = new PartnerNode(6,"凝光");
//		doubleLinkedList.update(partnerNode5);
//		doubleLinkedList.showList();
//		doubleLinkedList.delete(9);
//		System.out.println();
//		doubleLinkedList.showList();
		doubleLinkedList.addBOrder(partnerNode3);
		doubleLinkedList.addBOrder(partnerNode1);
		doubleLinkedList.addBOrder(partnerNode4);
		doubleLinkedList.addBOrder(partnerNode2);
		doubleLinkedList.showList();
	}

}
