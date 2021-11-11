package com.fcl.queue;

public class ArrayQueue {
	private int maxSize;
	private int front;
	private int rear;
	private int arrayQueue[];
	
	//队列构造器
	public ArrayQueue(int maxSize) {
		this.maxSize = maxSize;
		front = -1;
		rear = -1;
		arrayQueue = new int[maxSize];
	}
	
	//判断是否为空
	public boolean isEmpty() {
		return front == rear;
	}
	
	//判断是否为满
	public boolean isFull() {
		return rear == maxSize-1;
	}
	
	//向队列添加数据
	public void add(int value) {
		//先判断是否为满 满 无法添加 
		if (isFull()) {
			System.out.println("队列已满，无法添加");
			return;
		}
		rear++;
		arrayQueue[rear] = value;
	}
	
	//从队列取数据
	public int getValue() {
		//先判断是否为空
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		front++;
		return arrayQueue[front];
	}
	
	//dd
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("队列为空");
			return;
		}
		for (int i = front+1; i <= rear; i++) {
			System.out.printf("%d ",arrayQueue[i]);
		}
	}
}
