package sort;

public class BubbleSort {
	public static void main(String[] args) {
//		int[] a = {3, 4, 2, 1, 5, 6, 7, 8};
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] sort = sort(a);
		System.out.println(sort);
	}

	//冒泡
	public static int[] sort(int[] args) {
		if (null == args || args.length < 2) {
			return args;
		}
		int temp;
		for (int i = 0; i < args.length - 1; i++) {
			for (int y = 0; y < args.length - i - 1; y++) {
				if (args[y] > args[y + 1]) {
					temp = args[y + 1];
					args[y + 1] = args[y];
					args[y] = temp;
				}
			}
		}
		return args;
	}

	//冒泡优化
	public static int[] sort1(int[] args) {
		if (null == args || args.length < 2) {
			return args;
		}
		int temp;
		boolean flag = false;
		for (int i = 0; i < args.length - 1; i++) {
			for (int y = 0; y < args.length - i - 1; y++) {
				if (args[y] > args[y + 1]) {
					flag = true;
					temp = args[y + 1];
					args[y + 1] = args[y];
					args[y] = temp;
				}
			}
			if (!flag) {
				break;
			}
		}
		return args;
	}

	//冒泡最终优化
	public static int[] sort2(int[] args) {
		if (null == args || args.length < 2) {
			return args;
		}
		int temp;
		boolean flag = false;
		int lastIndex = 0;
		int z = args.length - 1;
		for (int i = 0; i < args.length - 1; i++) {
			for (int y = 0; y < z; y++) {
				if (args[y] > args[y + 1]) {
					lastIndex = y;
					flag = true;
					temp = args[y + 1];
					args[y + 1] = args[y];
					args[y] = temp;
				}
			}
			z = lastIndex;
			if (!flag) {
				break;
			}
		}
		return args;
	}
}
