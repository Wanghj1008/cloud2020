package sort;

public class ShellSort {
	public static void main(String[] args) {
		int[] a = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
		sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
	}

	/**
	 * 希尔排序：直接插入排序的升级版
	 */
	public static void sort(int[] array) {
		int j;
		int count=0;
		for (int gap = array.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < array.length; i++) {
				int tem = array[i];
				for (j = i; j >= gap && tem < array[j - gap]; j -= gap) {
					count++;
					array[j] = array[j - gap];
				}
				array[j] = tem;
			}
		}
		System.out.println(count);
	}
}
