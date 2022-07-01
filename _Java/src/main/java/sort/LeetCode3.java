package sort;

//：给定⼀个字符串 s ，请你找出其中不含有重复字符的 最⻓⼦串 的⻓度
public class LeetCode3 {
	/**
	 * ⽆重复字符的最⻓⼦串
	 * （滑动指针）
	 * 1. 使⽤字符数组 记录已遍历过的值
	 * 2. 只要 r 未越界且 字符数组不存在该值，移动r 且 添加⾄ 字符数组
	 * 3. 否则 移动l 且 删除 字符数组
	 * 4. result 获取每次移动后的最⼤值
	 * 5. 当字符遍历完成，返回result
	 */
	public int lengthOfLongestSubstring(String s) {
		int result = 0;
		int l = 0;
		int r = -1;
		char[] memo = new char[666];
		while (l < s.length()) {
			if (r + 1 < s.length() && memo[s.charAt(r + 1)] == 0) {
				memo[s.charAt(++r)]++;
			} else {
				memo[s.charAt(l++)]--;
			}
			result = Math.max(result, r - l + 1);
		}
		return result;

	}



}
