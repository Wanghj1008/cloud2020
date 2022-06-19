package sort;
/*给定⼀个整数数组 nums ，找到⼀个具有最⼤和的连续⼦数组（⼦数组最少包含⼀个元素），返回其最⼤和。*/
public class LeetCode53 {
	/**
	 最⼤⼦序和(贪⼼算法)
	 res作为历史最佳解，
	 sum作为当前最佳解，
	 每⼀次遍历nums数组时，
	 都去动态更新res和sum。
	 动态更新的逻辑为： 如果sum为正数，在有res记录历史最佳值的条件下，可以有恃⽆恐地继续累加，创造新⾼；
	 如果sum为负数，不管下⼀次遍历值是多少累加后都不会⼤于它，⻅⻛使舵果断取下⼀个遍历值为当前最佳解。
	 每⼀轮遍历结束后，如果当前最佳解优于历史最佳解，就会升任历史最佳解。
	 */
	public static int maxSubArray(int[] nums) {
		int res = nums[0];
		int sum = 0;
		for (int num : nums) {
			if (sum > 0) {
				sum = sum + num;
			} else {
				sum = num;
			}
			res = Math.max(res, sum);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] a={13,26 ,1,7,-3,-25,-60,-71,-30,112};
		System.out.println(maxSubArray(a));
	}
}
