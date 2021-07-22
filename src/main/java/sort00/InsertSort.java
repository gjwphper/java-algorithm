package sort00;

public class InsertSort {
    public static void main(String[] args) {
        int[] list = {6, 3, 5, 2, 4, 1};
        insertSort(list);
        System.out.println(list);

    }

//    public static void insertSort(int[] list) {
//        // 从第二个数开始，往前插入数字
//        for (int i = 1; i < list.length; i++) {
//            // j 记录当前数字下标
//            int j = i;
//            // 当前数字比前一个数字小，则将当前数字与前一个数字交换
//            while (j >= 1 && list[j] < list[j - 1]) {
//                swap(list, j, j - 1);
//                // 更新当前数字下标
//                j--;
//            }
//        }
//    }


    public static void insertSort(int[] arr) {
        // 从第二个数开始，往前插入数字
        for (int i = 1; i < arr.length; i++) {
            // j 记录当前数字下标
            int j = i;
            // 当前数字比前一个数字小，则将当前数字与前一个数字交换
            while (j >= 1 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
//                System.out.println(arr);
                // 更新当前数字下标
                j--;
            }
        }
    }

    private static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

}
