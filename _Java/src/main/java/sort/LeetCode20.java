package sort;

import java.util.LinkedList;

/*
* 给定⼀个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
有效字符串需满⾜：
左括号必须⽤相同类型的右括号闭合。
左括号必须以正确的顺序闭合
* */
public class LeetCode20 {

	/**
	 * 有效括号
	 * 1. 借助Stack 栈先进先出的特性，将左侧括号进⼊栈
	 * 2. 当前character不是左侧括号时，则pop出来⽐对是否匹配
	 * 3. 注意要判断边界问题（在pop前 memo的⼤⼩是否为0，在遍历后，meme的⼤⼩是否为0）
	 */
	public static boolean isValid(String s) {
		LinkedList<Character> memo = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
				memo.push(s.charAt(i));
			} else {
				if (memo.size() == 0) {
					return false;
				}
				Character pop = memo.pop();
				Character c = null;
				if (pop.equals('(')) {
					c = ')';
				}
				if (pop.equals('{')) {
					c = '}';
				}
				if (pop.equals('[')) {
					c = ']';
				}
				if (!c.equals(s.charAt(i))) {
					return false;
				}
			}
		}
		if (memo.size() != 0) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isValid("()(())"));
	}



}
