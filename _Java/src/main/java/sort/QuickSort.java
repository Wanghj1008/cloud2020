package sort;

public class QuickSort {

	private static void quickSort(int[] array, int low, int high) {
		if (null == array || array.length < 2|| low>=high) {
			return ;
		}
		int i = low;
		int j = high;
		int temp = array[low];

		while (i < j) {
			while (temp <= array[j] && i < j) {
				j--;
			}
			while (temp >= array[i] && i < j) {
				i++;
			}
			if (i < j) {
				int z = array[i];
				array[i] = array[j];
				array[j] = z;
			}
		}
		array[low] = array[i];
		array[i] = temp;

		quickSort(array, low,j-1);
		quickSort(array, j+1, high);
	}

	public static void main(String[] args) {
//		int[] array={10,7,2,4};
		int[] array={10,7,2,4,7,62,3,4,2,1,8,9,19};
		quickSort(array, 0, array.length - 1);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+ "\t");
		}
	}

}
