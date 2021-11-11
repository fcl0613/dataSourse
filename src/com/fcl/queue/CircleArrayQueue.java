package com.fcl.queue;

public class CircleArrayQueue {
	
	private int maxSize;
	private int front;		//指向队列第一个元素,默认为0
	private int rear;		//指向队列最后一个元素,默认为0
	private int[] circleArray;
	
	//构造器
	public CircleArrayQueue(int maxSize) {
		this.maxSize = maxSize;
		circleArray = new int[maxSize];
	}
	
	//判断为空
	public boolean isEmpty() {
		return front == rear;
	}
	
	//判断为满
	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}
	
	//添加数据
	public void add(int value) {
		//先判断队列是否为满
		if (isFull()) {
			System.out.println("队列已满，无法添加");
			return;
		}
		circleArray[rear] = value;
		rear = (rear + 1) % maxSize;
	}
	
	//取数据
	public int getValue() {
		//先判断为空
		if (isEmpty()) {
			throw new RuntimeException("队列为空无法取数据");
		}
		int temp = circleArray[front];
		front = (front + 1) % maxSize;
		return temp;
	}
	
	//显示数据
	public void showArray() {
		if (isEmpty()) {
			System.out.println("队列中没有数据");
			return;
		}
		for (int i = front; i < front + getSize(); i++) {
			System.out.printf("%d\t",circleArray[i % maxSize]);
		}
		System.out.println();
	}
	
	//获取队列的有效数据
	public int getSize() {
		return (rear + maxSize - front) % maxSize;
	}
}
