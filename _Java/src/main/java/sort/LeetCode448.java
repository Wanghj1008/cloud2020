package sort;

import java.util.ArrayList;
import java.util.List;

//给你⼀个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但
//没有出现在 nums 中的数字，并以数组的形式返回结果。
public class LeetCode448 {
	/**
	 * 448. 找到所有数组中消失的数字
	 * （不能⽤额外的空间）
	 * 数字范围1~n，⽽数组下标0~(n-1)，则可⽤数组原地标记数字是否出现过
	 */
	public static List<Integer> findDisappearedNumbers(int... nums) {
		List<Integer> res = new ArrayList<>();
		List<Integer> res1 = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			res.add(nums[i]);
		}
		for (int i = nums.length; i > 0; i--) {
			if(!res.contains(i))
				res1.add(i);
		}
		return res1;
	}

	public static void main(String[] args) {
		int[] a = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
		List<Integer> disappearedNumbers = findDisappearedNumbers(a);
		for (int i = 0; i < disappearedNumbers.size(); i++) {
			System.out.print(disappearedNumbers.get(i) + "\t");
		}
	}


}
