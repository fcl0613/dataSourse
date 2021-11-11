package com.fcl.singlelinklist;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PartnerNode partnerNode1 = new PartnerNode(1,"胡桃");
		PartnerNode partnerNode2 = new PartnerNode(2,"刻晴");
		PartnerNode partnerNode3 = new PartnerNode(6,"甘雨");
		PartnerNode partnerNode4 = new PartnerNode(8,"烟绯");
		SingleLinkList singleLinkList = new SingleLinkList();
		singleLinkList.add(partnerNode1);
		singleLinkList.add(partnerNode2);
		singleLinkList.add(partnerNode3);
		singleLinkList.add(partnerNode4);
		
		
		PartnerNode partnerNode5 = new PartnerNode(3,"影");
		PartnerNode partnerNode6 = new PartnerNode(4,"霄宫");
		PartnerNode partnerNode7 = new PartnerNode(5,"心海");
		PartnerNode partnerNode8 = new PartnerNode(7,"神里");
		SingleLinkList singleLinkList1 = new SingleLinkList();
		singleLinkList1.add(partnerNode5);
		singleLinkList1.add(partnerNode6);
		singleLinkList1.add(partnerNode7);
		singleLinkList1.add(partnerNode8);
		
		PartnerNode head = SingleLinkList.mergeLink(singleLinkList.getHead(), singleLinkList1.getHead());
		PartnerNode temp = head.next;
		while (temp !=null) {
			System.out.println(temp);
			temp = temp.next;
		}
		
//		singleLinkList.add(partnerNode1);
//		singleLinkList.add(partnerNode2);
//		singleLinkList.add(partnerNode4);
//		singleLinkList.add(partnerNode3);
//		singleLinkList.addByOrder(partnerNode3);
//		singleLinkList.addByOrder(partnerNode1);
//		singleLinkList.addByOrder(partnerNode2);
//		singleLinkList.addByOrder(partnerNode4);
//		PartnerNode partnerNode5 = new PartnerNode(5, "凝光");
//		PartnerNode partnerNode6 = new PartnerNode(4, "钟离");
//		singleLinkList.update(partnerNode5);
//		singleLinkList.update(partnerNode6);
//		singleLinkList.delete(8);
//		singleLinkList.delete(2);
//		singleLinkList.showLinkList();
//		System.out.println(SingleLinkList.getLength(singleLinkList.getHead()));
//		System.out.println("倒数第四个节点是:"+SingleLinkList.getLastIndexNode(singleLinkList.getHead(), 4));
//		PartnerNode p = SingleLinkList.reverseLink(singleLinkList.getHead());
//		while(p != null) {
//			System.out.println(p);
//			p = p.next;
//		}
//		System.out.println("ssss");
//		SingleLinkList.reversePrintLink(singleLinkList.getHead());
	}

}
