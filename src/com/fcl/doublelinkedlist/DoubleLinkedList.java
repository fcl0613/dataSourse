package com.fcl.doublelinkedlist;

public class DoubleLinkedList {
	private PartnerNode head = new PartnerNode(0, "");

	public PartnerNode getHead() {
		return head;
	}

	
	
	/**
	 * 按编号顺序添加节点
	 * @param partnerNode
	 */
	public void addBOrder(PartnerNode partnerNode) {
		if (head.next == null) {
			head.next = partnerNode;
			partnerNode.pre = head;
			return;
		}
		PartnerNode temp = head;
		boolean flag = false;
		while (temp.next != null) {
			if (partnerNode.no < temp.next.no) {
				break;
			}
			if (partnerNode.no == temp.next.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			System.out.println("this node is existed");
			return;
		}
		//判断插入的节点是否在最后
		if (temp.next != null) {		//避免空指针异常
			partnerNode.next = temp.next;
			temp.next.pre = partnerNode;
		}
		temp.next = partnerNode;
		partnerNode.pre = temp;
	}

	/**
	 * 删除节点
	 * 
	 * @param no
	 */
	public void delete(int no) {
		PartnerNode temp = head.next;
		boolean flag = false;
		while (temp != null) {
			if (temp.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.pre.next = temp.next;
			if (temp.next != null) {
				temp.next.pre = temp.pre;
			}
		} else {
			System.out.println("Not find this node");
		}
	}

	/**
	 * 更新链表
	 * 
	 * @param partnerNode
	 */
	public void update(PartnerNode partnerNode) {
		if (head.next == null) {
			System.out.println("The list is NULL");
			return;
		}
		PartnerNode temp = head.next;
		boolean flag = false;
		while (temp != null) {
			if (temp.no == partnerNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.name = partnerNode.name;
		} else {
			System.out.println("Not find this node");
		}
	}

	/**
	 * 头插法
	 * 
	 * @param partnerNode
	 */
	public void addAfterHead(PartnerNode partnerNode) {
		if (head.next == null) {
			head.next = partnerNode;
			partnerNode.pre = head;
			return;
		}
		partnerNode.next = head.next;
		head.next.pre = partnerNode;
		head.next = partnerNode;
		partnerNode.pre = head;
	}

	/**
	 * 尾插法
	 * 
	 * @param partnerNode
	 */
	public void add(PartnerNode partnerNode) {
		PartnerNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = partnerNode;
		partnerNode.pre = temp;
	}

	/**
	 * 正向遍历双向链表
	 */
	public void showList() {
		PartnerNode temp = head.next;
		while (temp != null) {
			System.out.println(temp);
			temp = temp.next;
		}
	}

	/**
	 * 反向遍历双向链表
	 * 
	 * @param rear
	 */
	public void showListReverse(PartnerNode rear) {
		PartnerNode temp = rear;
		while (temp != null) {
			System.out.println(temp);
			temp = temp.pre;
		}
	}
}
