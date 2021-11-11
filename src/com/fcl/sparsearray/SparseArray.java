package com.fcl.sparsearray;

public class SparseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[][] = new int[6][6];
		array[0][3] = 1;
		array[5][2] = 2;
		array[1][3] = 1;
		array[4][4] = 2;
		System.out.println("原数组");
		for (int[] is : array) {
			for (int item : is) {
				System.out.printf("%d\t",item);
			}
			System.out.println();
		}
		
		int sparseArray[][] = toSparse(array);
		System.out.println("稀疏数组");
		for (int[] is : sparseArray) {
			for (int item : is) {
				System.out.printf("%d\t",item);
			}
			System.out.println();
		}
		
		int newArray[][] = recover(sparseArray);
		System.out.println("还原稀疏数组");
		for (int[] is : newArray) {
			for (int item : is) {
				System.out.printf("%d\t",item);
			}
			System.out.println();
		}
	}
	
	/*
	 * 转稀疏数组
	 */
	public static int[][] toSparse(int[][] array){
		int sum = 0;
		//遍历原数组，获取非0数字的数量
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] != 0) {
					sum++;
				}
			}
		}
		
		//创建稀疏数组
		int sparsearray[][] = new int[sum+1][3];
		//给稀疏数组第一行赋值，因为这是可以确定的
		sparsearray[0][0] = array.length;
		sparsearray[0][1] = array[1].length;
		sparsearray[0][2] = sum;
		int count = 0;		//稀疏数组计数器
		//遍历原数组，给稀疏数组赋值
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] != 0) {
					count++;
					sparsearray[count][0] = i;
					sparsearray[count][1] = j;
					sparsearray[count][2] = array[i][j];
				}
			}
		}
		return sparsearray;
	}

	
	/*
	 * 稀疏数组转原数组
	 */
	public static int[][] recover(int[][] sparseArray){
		//根据稀疏数组创建原数组的大小
		int array[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
		//遍历稀疏数组，并且赋值
		for (int i = 0; i < sparseArray[0][2]; i++) {
			array[sparseArray[i+1][0]][sparseArray[i+1][1]] = sparseArray[i+1][2];
		}
		return array;
	}
}
