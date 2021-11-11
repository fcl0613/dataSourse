package com.fcl.stack;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayStack arrayStack = new ArrayStack(3);
//		arrayStack.push(2);
//		arrayStack.push(3);
//		arrayStack.push(4);
//		arrayStack.push(5);
//		arrayStack.pop();
//		System.out.println();
//		arrayStack.showArrayStack();
		SingleLinkStack singleLinkStack = new SingleLinkStack();
		singleLinkStack.showStack();
		singleLinkStack.push(2);
		singleLinkStack.push(4);
		singleLinkStack.push(33);
		singleLinkStack.showStack();
		System.out.println();
		System.out.println(singleLinkStack.pop());
		System.out.println();
		singleLinkStack.showStack();
		singleLinkStack.push(88);
		singleLinkStack.showStack();
	}

}
