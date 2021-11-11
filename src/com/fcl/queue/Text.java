package com.fcl.queue;

import java.util.Scanner;

public class Text {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayQueue arrayQueue = new ArrayQueue(3);
//		System.out.println(arrayQueue.isEmpty());
//		arrayQueue.add(3);
//		arrayQueue.add(5);
//		arrayQueue.add(1);
//		System.out.println(arrayQueue.isFull());
//		arrayQueue.add(2);
//		System.out.println(arrayQueue.getValue());
//		arrayQueue.showQueue();
		
		
		CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4);
//		circleArrayQueue.add(1);
//		circleArrayQueue.add(2);
//		circleArrayQueue.add(3);
//		circleArrayQueue.showArray();
//		circleArrayQueue.add(4);
		
		char key;
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while(loop) {
			System.out.println("a:添加数据");
			System.out.println("b:判断是否为空");
			System.out.println("c:判断是否为满");
			System.out.println("d:取出数据");
			System.out.println("e:显示队列");
			System.out.println("f:程序退出");
			key = scanner.next().charAt(0);
			switch(key) {
				case 'a':
					System.out.println("请输入一个整数");
					int a = scanner.nextInt();
					circleArrayQueue.add(a);
					break;
				case 'b':
					System.out.println(circleArrayQueue.isEmpty());
					break;
				case 'c':
					System.out.println(circleArrayQueue.isFull());
					break;
				case 'd':
					System.out.println(circleArrayQueue.getValue());
					break;
				case 'e':
					circleArrayQueue.showArray();
					break;
				case 'f':
					loop = false;
					break;
				default:
					break;
			}
		}
		scanner.close();
	}

}
