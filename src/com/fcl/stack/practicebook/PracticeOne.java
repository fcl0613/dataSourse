package com.fcl.stack.practicebook;


/**
 * 分隔符匹配问题
 * @author FCL
 *
 */
public class PracticeOne {
	private final int LEFT = 0;
	private final int RIGHT = 1;
	private final int OTHER = 2;
	
	/**
	 * 判断分隔符类型
	 * @param s
	 * @return
	 */
	public int verifyFlag(String s) {
		if ("(".equals(s) || "[".equals(s) || "{".equals(s) || "/*".equals(s)) {
			return LEFT;
		}else if (")".equals(s) || "]".equals(s) || "}".equals(s) || "*/".equals(s)) {
			return RIGHT;
		}else {
			return OTHER;
		}
	}
	
	
	/**
	 * 判断字符是否匹配
	 * @param s1
	 * @param s2
	 * @return
	 */
	public boolean matches(String s1, String s2) {
		if (("(".equals(s1) && ")".equals(s2))
			|| ("[".equals(s1) && "]".equals(s2))
			|| ("{".equals(s1) && "}".equals(s2))
			|| ("/*".equals(s1) && "*/".equals(s2))) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public boolean isLegal(String s) {
		if (!"".equals(s) && s != null) {
			SqStack sqStack = new SqStack(100);
			int length = s.length();
			for (int i = 0; i < length; i++) {
				char c = s.charAt(i);
				String str = String.valueOf(c);
				if (i != length) {			//不是最后一个字符
					if (('/' == c && '*' == s.charAt(i+1)) || ('*' == c && '/' == s.charAt(i+1))) {
						str = str.concat(String.valueOf(s.charAt(i)+1));
						i++;
					}
				}
				if (LEFT == verifyFlag(str)) {
					sqStack.push(str);
				}else if(RIGHT == verifyFlag(str)) {
					if (sqStack.isEmpty() || !matches(sqStack.pop().toString(), str)) {
						throw new RuntimeException("false");
					}
				}
			}
			if (!sqStack.isEmpty()) {
				throw new RuntimeException("false");
			}else {
				return true;
			}
		}else {
			throw new RuntimeException("false");
		}
	}
}
