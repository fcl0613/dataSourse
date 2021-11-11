package com.fcl.sparsearray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class IOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Writer writer = null;
		try {
			writer = new FileWriter("D:\\Programming\\Java_workplace\\biliDateStructure\\src\\com\\fcl\\sparsearray\\te.txt");
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			int array[][] = {{6,6,4},{0,3,1},{1,3,1},{4,4,2},{5,2,2}};
			for (int[] is : array) {
				for (int is2 : is) {
					bufferedWriter.write(String.valueOf(is2)+"\t");
				}
				bufferedWriter.write("\n");
			}
			bufferedWriter.flush();
			bufferedWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			Reader reader = new FileReader("D:\\Programming\\Java_workplace\\biliDateStructure\\src\\com\\fcl\\sparsearray\\te.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
			String str = null;
			try {
				str = bufferedReader.readLine();
				String[] temp = str.split("\t");
				int sparseArray[][] = new int[Integer.parseInt(temp[2])+1][3];
				int count = 0;
				for (int i = 0; i < temp.length; i++) {
//					System.out.println(temp[i]);
					sparseArray[count][0] = Integer.parseInt(temp[0]);
					sparseArray[count][1] = Integer.parseInt(temp[1]);
					sparseArray[count][2] = Integer.parseInt(temp[2]);
				}
				count++;
				while((str = bufferedReader.readLine()) != null) {
//					System.out.println(str);
					temp = str.split("\t");
//					System.out.println(temp.toString());
					for (int i = 0; i < temp.length; i++) {
//						System.out.println(temp[i]);
						sparseArray[count][0] = Integer.parseInt(temp[0]);
						sparseArray[count][1] = Integer.parseInt(temp[1]);
						sparseArray[count][2] = Integer.parseInt(temp[2]);
					}
					count++;
				}
				bufferedReader.close();
				for (int[] is : sparseArray) {
					for (int item : is) {
						System.out.printf("%d\t",item);
					}
					System.out.println();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
