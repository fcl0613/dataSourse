package com.fcl.singlelinklist;

import java.util.Stack;

public class SingleLinkList {
	//先声明一个头节点
	private PartnerNode head = new PartnerNode(0, "");
	
	public PartnerNode getHead() {
		return head;
	}
	
	
	/**
	 * 合并两个有序单链表
	 * 输出后任然有序
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static PartnerNode mergeLink(PartnerNode head1,PartnerNode head2) {
		PartnerNode head = new PartnerNode(0, "");
		PartnerNode cur1, cur2;
		PartnerNode cur = head;
		cur1 = head1.next;
		cur2 = head2.next;
		while(cur1 != null || cur2 != null) {
			if (cur1 == null) {
				cur.next = cur2;
				return head;
			}
			if (cur2 == null) {
				cur.next = cur1;
				return head;
			}
			if (cur1.no < cur2.no) {
				cur.next = cur1;
				cur = cur.next;
				cur1 = cur1.next;
			}else {
				cur.next = cur2;
				cur = cur.next;
				cur2 = cur2.next;
			}
		}
		return head;
	}
	
	
	
	/**
	 * 反向打印链表
	 * 使用栈方式实现   不会破坏表的结构
	 * @param head
	 */
	public static void reversePrintLink(PartnerNode head) {
		PartnerNode cur = head.next;
		Stack<PartnerNode> stack = new Stack<PartnerNode>();
		while(cur != null) {
			stack.add(cur);
			cur = cur.next;
		}
		while(stack.size()>0) {
			System.out.println(stack.pop());
		}
	}
	
	
	
	/**
	 * 使用头插法实现链表的反转
	 * @param head
	 * @return
	 */
	public static PartnerNode reverseLink1(PartnerNode head) {
		if (head.next == null || head.next.next == null) {
			return head;
		}
		PartnerNode head1 = new PartnerNode(0, "");
		PartnerNode next;
		PartnerNode cur = head.next;
		while(cur != null) {
			next = cur.next;			//保存当前节点的下一个节点
			cur.next = head1.next;		//把当前节点指向head1的下一个节点，即插入到新列表的头部
			head1.next = cur;			//将新链表的头部指向刚刚插入的节点
			cur = next;					//cur后移
		}
		return head1;
	}
	
	
	
	//单链表的反转
	/**
	 * 迭代算法
	 * @param head
	 * @return
	 */
	public static PartnerNode reverseLink(PartnerNode head) {
		PartnerNode prve = null, next;
		PartnerNode temp = head.next;
		while(temp != null) {
			next = temp.next;
			temp.next = prve;
			prve = temp;
			temp = next;
		}
		return prve;
	}
	
	
	
	//获取倒数第n个节点的信息
	public static PartnerNode getLastIndexNode(PartnerNode head, int index) {
		if (head.next == null) {
			return null;
		}
		int length = SingleLinkList.getLength(head);
		if (index<=0 || index>length) {
			return null;
		}
		PartnerNode temp = head.next;
		for (int i = 0; i < length-index; i++) {
			temp = temp.next;
		}
		return temp;
	} 
	
	
	//计算链表的长度
	public static int getLength(PartnerNode head) {
		int length = 0;
		PartnerNode temp = head;
		while(temp.next != null) {
			length++;
			temp = temp.next;
		}
		return length;
	}
	
	
	
	
	//向链表中添加节点
	//不考虑添加顺序
	public void add(PartnerNode partnerNode) {
		PartnerNode temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = partnerNode;
	}
	
	//根据序号添加节点
	public void addByOrder(PartnerNode partnerNode) {
		PartnerNode temp = head;
		//如果是第一个节点的添加
		boolean flag = false;
		while(true) {
			if (temp.next == null) {
				break;
			}
			if (temp.next.no > partnerNode.no) {
				break;
			}
			if (temp.next.no == partnerNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			System.out.println("数据重复，无法添加");
		}else {
			partnerNode.next = temp.next;
			temp.next = partnerNode;
		}
	}
	
	
	//修改节点
	public void update(PartnerNode partnerNode) {
		if (head.next == null) {
			System.out.println("链表为空");
		}
		PartnerNode temp = head;
		while(true) {
			if (temp.next == null) {
				break;
			}
			if (temp.no == partnerNode.no) {
				break;
			}
			temp = temp.next;
		}
		if (temp.next == null) {
			addByOrder(partnerNode);
		}else {
			temp.name = partnerNode.name;
		}
	}
	
	
	//删除节点
	public void delete(int no) {
		PartnerNode temp = head;
		boolean flag = false;
		while(true) {
			if (temp.next == null) {
				break;
			}
			if (temp.next.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.next = temp.next.next;
		}else {
			System.out.println("没有找到该节点");
		}
	}
	
	
	
	//显示链表
	public void showLinkList() {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		PartnerNode temp = head.next;
		while(temp != null) {
			System.out.println(temp);
			temp = temp.next;
		}
	}
}
