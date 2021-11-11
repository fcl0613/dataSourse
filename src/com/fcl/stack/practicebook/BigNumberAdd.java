package com.fcl.stack.practicebook;

public class BigNumberAdd {
	
	
	public String add(String s1, String s2) {
		//先定义两个存放两个加数的字符栈
		LinkStack linkStack1 = numSplit(s1);
		LinkStack linkStack2 = numSplit(s2);
		LinkStack sumLink = new LinkStack();		//求和的数字栈
		int cursum = 0;								//计算的和
		boolean isCarry = false;		//是否有进位
		while(!linkStack1.isEmpty() && !linkStack2.isEmpty()) {				//两个栈都不为空的情况下
			cursum = (Integer)linkStack1.pop() + (Integer)linkStack2.pop();
			if (isCarry) {			//如果有进位，cursum++ 后进位标识置为false
				cursum++;
				isCarry = false;
			}
			if (cursum >= 10) {		//如果两个书计算的结果大于等于10，说明有进位
				isCarry = true;
				cursum -= 10;
				sumLink.push(cursum);
			}else {					//两数相加没有超过10，则直接进栈
				sumLink.push(cursum);
			}
		}
		//判断还有哪一个栈不为空
		LinkStack temp = !linkStack1.isEmpty() ? linkStack1 : linkStack2;
		while(!temp.isEmpty()) {
			if (isCarry) {			//如果前面的运算还有留下进位
				int t = (Integer)temp.pop();
				t++;
				if (t >= 10) {		//弹出的数加上之前的进位还是大于等于十的情况
					t -= 10;
					sumLink.push(t);
				}else {				//弹出的数加上之前的进位还是小于十的情况，则直接入栈，进位标识置false
					sumLink.push(t);
					isCarry = false;
				}
			}else {				//如果前面没有进位，则依次进如sumLink栈
				sumLink.push(temp.pop());
			}
		}
		if (isCarry) {			//如果运算到最后有进位，则进栈数字1，即最高位添1
			sumLink.push(1);
		}
		StringBuilder sum = new StringBuilder();
		while(!sumLink.isEmpty()) {
			sum.append(sumLink.pop().toString());
		}
		return sum.toString();
	}
	
	
	/**
	 * 分割数字字符串
	 * @param s
	 * @return
	 */
	public LinkStack numSplit(String s) {
		LinkStack linkStack = new LinkStack();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (' ' == c) {
				continue;
			}else if('0' <= c || '9' >= c) {
				linkStack.push(Integer.valueOf(String.valueOf(c)));
			}else {
				throw new RuntimeException("the char is not number type");
			}
		}
		return linkStack;
	}
}
