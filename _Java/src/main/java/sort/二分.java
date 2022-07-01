package sort;

import java.util.Collections;

public class 二分 {
	//Arrays和Collections 中都提供了二分算法 binarySearch
	//问题  找到有序数组中 传入值的下标  没有返回-1
	public static void main(String[] args) {
		int[] num = {-1, 0, 3, 5, 9, 12};
		System.out.println(search(num, 9));
		System.out.println(test("Ooook"));
	}

	public static int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (right >= left) {
			int i = (left + right) / 2;
			if (nums[i] == target) {
				return i;
			} else if (nums[i] > target) {
				right = i - 1;
			} else {
				left = i + 1;
			}
		}
		return -1;
	}

	/*
	你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
    假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
    你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。

    示例 1：
    输入：n = 5, bad = 4
    输出：4
    解释：
    调用 isBadVersion(3) -> false
    调用 isBadVersion(5) -> true
    调用 isBadVersion(4) 	-> true
    所以，4 是第一个错误的版本。
	*/
	public int firstBadVersion(int n) {
		int left = 1;
		int right = n;
		while (left < right) {
			int i = left + (right - left) / 2;
			if (isBadVersion(i)) {
				right = i;
			} else {
				left = i + 1;
			}
		}
		return -1;
	}

	private boolean isBadVersion(int i) {
		return false;
	}

	public static String test(String s) {
		if (s != null && s.length() > 1) {
			return "Wrong";
		}

		if (!(s.charAt(0) >= 'a' && s.charAt(0) <= 'z') && !(s.charAt(0) >= 'A' && s.charAt(0) <= 'Z')) {
			return "Wrong";
		}

		boolean flag =false;
		for (int i = 1; i < s.length(); i++) {
			if(s.charAt(i) >= 0 && s.charAt(i) <= 9){
				flag=true;
				continue;
			}
			if (!(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') && !(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') && !(s.charAt(i) >= 0 && s.charAt(i) <= 9)) {
				return "Wrong";
			}
		}
		if(flag)
			return "Accept";
		return "Wrong";
	}

}
