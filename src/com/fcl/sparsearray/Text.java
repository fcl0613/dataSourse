package com.fcl.sparsearray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Text {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int array[][] = new int[6][6];
		array[0][3] = 1;
		array[5][2] = 2;
		array[1][3] = 1;
		array[4][4] = 2;
		String file = "D:\\Programming\\Java_workplace\\biliDateStructure\\src\\com\\fcl\\sparsearray\\te.txt";
		int sparseArray[][] = SparseArray.toSparse(array);
//		for (int[] is : sparseArray) {
//			for (int is2 : is) {
//				System.out.printf("%d\t",is2);
//			}
//			System.out.println();
//		}
		//存稀疏数组
		Writer writer = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		for (int[] is : sparseArray) {
			for (int is2 : is) {
				bufferedWriter.write(String.valueOf(is2)+"\t");
			}
			bufferedWriter.write("\n");
		}
		bufferedWriter.flush();
		bufferedWriter.close();
		
		//取稀疏数组
		Reader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String str = null;
		str = bufferedReader.readLine();
		String temp[] = str.split("\t");
		int sparray[][] = new int[Integer.parseInt(temp[2])+1][3];
		int count = 0;
		sparray[count][0] = Integer.parseInt(temp[0]);
		sparray[count][1] = Integer.parseInt(temp[1]);
		sparray[count][2] = Integer.parseInt(temp[2]);
		count++;
		while ((str = bufferedReader.readLine())!=null) {
			temp = str.split("\t");
			sparray[count][0] = Integer.parseInt(temp[0]);
			sparray[count][1] = Integer.parseInt(temp[1]);
			sparray[count][2] = Integer.parseInt(temp[2]);
			count++;
		}
		bufferedReader.close();
		for (int[] is : sparray) {
			for (int is2 : is) {
				System.out.printf("%d\t",is2);
			}
			System.out.println();
		}
		int re[][] = SparseArray.recover(sparray);
		for (int[] is : re) {
			for (int is2 : is) {
				System.out.printf("%d\t",is2);
			}
			System.out.println();
		}
	}	

}
