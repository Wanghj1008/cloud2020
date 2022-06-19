package sort;

import java.util.HashMap;
import java.util.Map;

/*问题：
给定⼀个整数数组 nums 和⼀个整数⽬标值 target，
请你在该数组中找出 和为⽬标值 target 的那 两 个 整数，并返回它们的数组下标。
你可以假设每种输⼊只会对应⼀个答案。但是，数组中同⼀个元素在答案⾥不能重复出现。*/
public class TwoSum {

	public static void main(String[] args) {
		int[] a = {1, 5, 7, 9, 10, 15, 18, 21, 53};
		int[] ints = twoSum(a, 16);
		for (int i = 0; i < ints.length; i++) {
			System.out.print(ints[i] + "\t");
		}
	}


	/**
	 * 两数之和
	 * 1. Map存储着val 对应的下标
	 * 2. target - num[i] 在Map中有存储，则能算出结果
	 */
	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int temp = target - nums[i];
			if (map.containsKey(temp)) {
				return new int[]{map.get(temp), i};
			} else {
				map.put(nums[i], i);
			}
		}
		return new int[2];
	}
}
