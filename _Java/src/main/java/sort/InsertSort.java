package sort;

public class InsertSort {
	public static void main(String[] args) {
		int[] a = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
		sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
	}

	public static void sort(int[] array) {

		int j;
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			for (j = i - 1; j >= 0 && array[j] > temp; j--) {
				array[j + 1] = array[j];
			}
			array[j + 1] = temp;
		}
	}
}
