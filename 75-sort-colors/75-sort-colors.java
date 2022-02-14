class Solution {
        public static void sortColors(int[] arr) {
        int size = arr.length;
        int low = 0, mid = 0, high = size - 1;
        while (mid <= high) {
            switch (arr[mid]) {
                // if the value is 0
                case 0 : {
                    swap(arr, mid, low);
                    low++;
                    mid++;
                    break;
                }
                case 1 : {
                    mid++;
                    break;
                }
                case 2 : {
                    swap(arr, mid, high);
                    high--;
                    break;
                }
            }
        }
            System.out.println(Arrays.toString(arr));
    }

    // swap method i.e used in sort method
    private static void swap(int[] arr, int x, int y) {
        int temp;
        temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}