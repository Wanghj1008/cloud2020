package sort;

public class SelectSort {
	public static void main(String[] args) {
		int[] a = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
		sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
	}

	public static void sort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int index = i;
			for (int j = i; j < array.length; j++) {
				if (array[index] > array[j]) {
					index = j;
				}
			}
			int temp = array[i];
			array[i] = array[index];
			array[index] = temp;
		}
	}
}
