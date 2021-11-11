package com.fcl.stack.practicebook;

public class Hanoi {
	private int count = 0;
	public void hanoi(int n, char x, char y, char z) {
		if (n == 1) {
			move(x, 1, z);
		}else {
			hanoi(n-1,x,z,y);
			move(x, n, z);
			hanoi(n-1, y, z, x);
		}
	}
	
	public void move(char x, int n, char z) {
		System.out.println("第"+ ++count + "次移动:" + n + "号圆盘," + x + "->" + z);
	}
	
	public static void main(String[] args) {
		Hanoi h = new Hanoi();
		h.hanoi(4, 'x', 'y', 'z');
	}
}
