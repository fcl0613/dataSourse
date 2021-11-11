package com.fcl.stack.practicebook;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		SqStack sqStack = new SqStack(3);
//		sqStack.push(2);
//		sqStack.push(2);
//		sqStack.push(2);
//		sqStack.showStack();
//		sqStack.pop();
//		System.out.println();
//		sqStack.showStack();
		
//		LinkStack linkStack = new LinkStack();
//		linkStack.push(3);
//		System.out.println(linkStack.pop().toString());
//		linkStack.showStack();
//		linkStack.pop();
//		linkStack.push(3);
//		linkStack.push(3);
//		linkStack.push(3);
//		linkStack.showStack();
//		linkStack.pop();
//		linkStack.showStack();
		
//		PracticeOne practiceOne = new PracticeOne();
//		String s = "(ddfs)fdsfsdf {}/*adakldjlk*/";
//		System.out.println(practiceOne.isLegal(s));
		
//		BigNumberAdd bigNumberAdd = new BigNumberAdd();
//		System.out.println(bigNumberAdd.add("7833333333333334", "84444444444444444465"));
		
//		CalculatorSelf calculatorSelf = new CalculatorSelf();
//		String s = "(3.21)-3+7%2";
//		List<String> list = calculatorSelf.getExpressionList(s);
//		System.out.println(list);
//		System.out.println(calculatorSelf.convertToPostfix(list));
//		if ("3.33".matches("\\d+")) {
//			
//		}
//		System.out.println("3.33".matches("\\d+\\.{0,1}\\d*"));
//		List<String> list = new ArrayList<String>();
//		System.out.println(list.size());
		
		CalculatorSelf calculatorSelf = new CalculatorSelf();
		System.out.println(calculatorSelf.numberCalculator("(2+3)*2^3-9.2"));
	}

}
