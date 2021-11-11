package com.fcl.doublelinkedlist;

public class PartnerNode {
	public int no;
	public String name;
	public PartnerNode next;
	public PartnerNode pre;
	
	public PartnerNode(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	@Override
	public String toString() {
		return "PartnerNode [no=" + no + ", name=" + name + "]";
	}
}
