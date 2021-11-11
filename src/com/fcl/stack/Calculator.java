package com.fcl.stack;

public class Calculator {

	public static void main(String[] args) {
		String expression = "20+3*4-1-1-100";			//表达式
		//创建一个符号栈和数字栈
		ArrayStack1 numberStack = new ArrayStack1(10);			//数字栈
		ArrayStack1 operaterStack = new ArrayStack1(10);		//字符栈
		
		int index = 0;
		int num1 = 0;
		int num2 = 0;
		int operater = 0;
		int res = 0;
		char ch = ' ';			//用于保存每次扫描的字符
		String keepNumber = "";
		while(true) {
			ch = expression.subSequence(index, index + 1).charAt(0);
			if (operaterStack.isOperator(ch)) {
				if (operaterStack.isEmpty()) {
					operaterStack.push(ch);
				}else {
					if (operaterStack.priority(ch) <= operaterStack.priority(operaterStack.peek())) {
						num1 = numberStack.pop();
						num2 = numberStack.pop();
						operater = operaterStack.pop();
						res = numberStack.cal(num1, num2, operater);
						numberStack.push(res);
						operaterStack.push(ch);
					}else {
						operaterStack.push(ch);
					}
				}
			}else {
//				numberStack.push(ch - 48);
				keepNumber += ch;
				if (index == expression.length() - 1) {
					numberStack.push(Integer.parseInt(keepNumber));
				}else {
					if (operaterStack.isOperator(expression.substring(index + 1, index + 2).charAt(0))) {
						numberStack.push(Integer.parseInt(keepNumber));
						keepNumber = "";
					}
				}
			}
			index++;
			if (index >= expression.length()) {
				break;
			}
		}
		
		
		while(true) {
			if (operaterStack.isEmpty()) {
				break;
			}
			num1 = numberStack.pop();
			num2 = numberStack.pop();
			operater = operaterStack.pop();
			res = numberStack.cal(num1, num2, operater);
			numberStack.push(res);
		}
		System.out.println(numberStack.pop());
	}

}



class ArrayStack1{
	private int maxSize;
	private int top = -1;
	private int arrayStack[];
	
	public ArrayStack1(int maxSize) {
		this.maxSize = maxSize;
		arrayStack = new int[maxSize];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == maxSize - 1;
	}
	
	public void push(int value) {
		if (isFull()) {
			System.out.println("the stack is full");
			return;
		}
		top++;
		arrayStack[top] = value;
	}
	
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("the stack is empty");
		}
		int value = arrayStack[top];
		top--;
		return value;
	}
	
	public int peek() {
		if (isEmpty()) {
			throw new RuntimeException("the stack is empty");
		}
		return arrayStack[top];
	}
	
	
	/**
	 * 判断是否位运算符
	 * @param c
	 * @return
	 */
	public boolean isOperator(char c) {
		if (c == '-' || c == '+' || c == '*' || c=='/') {
			return true;
		}else {
			return false;
		}
	}
	
	
	/**
	 * 判断运算法的优先级
	 * 数字越大优先级越高，可以自定义
	 * @param c
	 * @return
	 */
	public int priority(int c) {
		if (c == '*' || c== '/') {
			return 2;
		}else if(c == '+' || c == '-') {
			return 1;
		}else {
			return 0;
		}
	}
	
	
	/**
	 * 计算方法
	 * @param num1
	 * @param num2
	 * @param oper
	 * @return
	 */
	public int cal(int num1, int num2, int oper) {
		int res = 0;
		switch(oper) {
			case '+':
				res = num1 + num2;
				break;
			case '-':
				res = num2 - num1;
				break;
			case '*':
				res = num1 * num2;
				break;
			case '/':
				res = num2 / num1;
				break;
		}
		return res;
	}
}
