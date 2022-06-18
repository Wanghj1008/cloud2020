package sort;

/**
 * @author 王昊杰
 * @version V1.0
 * @Package sort
 * @Email: 1624302283@qq.com
 * @date 2022/6/7 21:30
 * @Copyright
 */
public class Sort {


    public static void main(String[] args) {
        int[] a = {8, 12, 1, 46, 52, 2, 6, 65, 45};
        sort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
    }

    private static void sort(int[] a, int low, int high) {

        if (null == a || a.length < 2 || high <= low) {
            return;
        }

        int i = low;
        int j = high;
        int temp = a[low];
        while (j > i) {
            while (a[j] >= temp && j > i) {
                j--;
            }
            while (a[i] <= temp && j > i) {
                i++;
            }
            if (j > i) {
                int z = a[i];
                a[i] = a[j];
                a[j] = z;
            }
        }
        a[low] = a[i];
        a[i] = temp;

        sort(a, low, j -1);
        sort(a, j+1 , high);


    }


}
