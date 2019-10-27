class Quicksort {
    public static void quickSort(int[] arr, int left, int right) {
        int pivotIndex = left + (right - left) / 2;
        int pivotValue = arr[pivotIndex];
        int i = left, j = right;
        while (i <= j) {
            while (arr[i] < pivotValue) {
                i++;
            }
            while (arr[j] > pivotValue) {
                j--;
            }
            if (i <= j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
            if (left < i) {
                quickSort(arr, left, j);
            }
            if (right > i) {
                quickSort(arr, i, right);
            }
        }
    }
    
    public static void main(String[] a) {
    }
}