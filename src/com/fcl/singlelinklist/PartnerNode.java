package com.fcl.singlelinklist;

public class PartnerNode {
	public int no;
	public String name;
	public PartnerNode next;
	
	public PartnerNode(int no, String name) {
		this.no = no;
		this.name = name;
	}

	@Override
	public String toString() {
		return "PartnerNode [no=" + no + ", name=" + name + "]";
	}
}
