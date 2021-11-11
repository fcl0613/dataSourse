package com.fcl.stack.practicebook;

import java.util.ArrayList;
import java.util.List;

public class CalculatorSelf {

	/**
	 * 输入一个表达式的字符串，计算其值
	 * @param s
	 * @return
	 */
	public double numberCalculator(String s) {
		List<String> expression = getExpressionList(s);
		List<String> postfixList = convertToPostfix(expression);
		LinkStack linkStack = new LinkStack();
		for (String item : postfixList) {
			if (item.matches("\\d+\\.{0,1}\\d*")) {			//如果是操作数，则直接入栈
				linkStack.push(item);
			}else {							//如果是字符
				double d2 = Double.valueOf(linkStack.pop().toString());
				double d1 = Double.valueOf(linkStack.pop().toString());
				double d3 = 0;
				if ('+' == item.charAt(0)) {
					d3 = d1 + d2;
				}else if('-' == item.charAt(0)) {
					d3 = d1 - d2;
				}else if('*' == item.charAt(0)) {
					d3 = d1 * d2;
				}else if('/' == item.charAt(0)) {
					d3 = d1 / d2;
				}else if('%' == item.charAt(0)) {
					d3 = d1 % d2;
				}else if('^' == item.charAt(0)) {
					d3 = Math.pow(d1, d2);
				}
				linkStack.push(d3);
			}
		}
		return (Double)linkStack.pop();
	}
	
	
	
	/**
	 * 将中缀表达式转换成后缀表达式
	 * @param list	中缀表达式的列表形式
	 * @return 后缀表达式
	 */
	public List<String> convertToPostfix(List<String> list){
		LinkStack linkStack = new LinkStack();				//初始化一个字符栈
		List<String> postfix = new ArrayList<String>();
		for (String item : list) {
			if (item.matches("\\d+\\.{0,1}\\d*")) {			//如果是操作数，直接送往后缀表达式
				postfix.add(item);
			}else if("(".equals(item)) {			//如果是右括号，压栈
				linkStack.push(item);
			}else if (")".equals(item)) {
				//若当前字符是右括号时，反复将栈顶符号弹出，并送往后缀表达式，直到栈顶符号是左括号为止
				while(!linkStack.peek().equals("(")) {
					postfix.add(linkStack.pop().toString());
				}
				linkStack.pop();		//将栈顶的左括号移除
			}else {						//如果是运算符
				//当item的优先级小于等于栈顶的运算符，将linkList栈顶的运算符弹出并加入到postfix列表中
				while(!linkStack.isEmpty() && priority(item.charAt(0)) <= priority(linkStack.peek().toString().charAt(0))) {
					postfix.add(linkStack.pop().toString());
				}
				linkStack.push(item);
			}
		}
		//将字符栈中剩余的部分加入到postfix列表中
		while(!linkStack.isEmpty()) {
			postfix.add(linkStack.pop().toString());
		}
		return postfix;
	}
	
	
	/**
	 * 将中缀表达式字符串转换成对应的列表
	 * 
	 * 只是简单的判断了一下表达式是否为数字和运算符号，对于表达式其他正确的判断并未实现 
	 * 例如 
	 * 223///**3.11(2+3+2*(3-2))
	 * 
	 * 20....233这个问题没有解决
	 * 后面加了，但是目前没有出现错误
	 * @param s
	 * @return
	 */
	public List<String> getExpressionList(String s) {
		List<String> list = new ArrayList<String>();
		int index = 0;
		String str;
		do {
			if ('0' > s.charAt(index) || '9' < s.charAt(index)) {			//如果不是数值
				if (index < s.length() && isOperator(s.charAt(index + 1)) && isOperator(s.charAt(index))) {		//如果这一位和下一位都是运算符则表达式格式错误
					throw new RuntimeException("this ecpression is incorrect");
				}
				if (isOperator(s.charAt(index)) || '(' == s.charAt(index) || ')' == s.charAt(index)) {		//如果是运算符和圆括号，则直接添加进列表
					list.add(String.valueOf(s.charAt(index)));
					index++;
				} 
				else {					//其他非法字符
					throw new RuntimeException("this ecpression is incorrect");
				}
			} else {		//如果是数字
				str = "";
				while (index < s.length()) {		//如果是数字或者是小数点，循环，直到出现符号为止
					if ((('0' <= s.charAt(index) && '9' >= s.charAt(index))) || '.' == s.charAt(index)) {
						str += String.valueOf(s.charAt(index));				//字符串拼接
						index++;
					}else {
						break;
					}
				}
				list.add(str);				//循环结束后，将多位数、小数添加进列表
			}
		} while (index < s.length());
		return list;
	}

	/**
	 * 判断是否为运算符
	 * 
	 * @param c
	 * @return
	 */
	public boolean isOperator(char c) {
		if ('-' == c || '+' == c || '*' == c || '^' == c || '/' == c || '%' == c) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断运算符的优先级
	 * 
	 * @param c
	 * @return
	 */
	public int priority(char c) {
		if ('^' == c) {
			return 3;
		} else if ('*' == c || '/' == c || '%' == c) {
			return 2;
		} else if ('+' == c || '-' == c) {
			return 1;
		} else {
			return 0;
		}
	}
}
