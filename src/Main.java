import java.util.Arrays;

public class Main {
    static void heapify(int[] a, int i, int heapSize) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heapSize && a[left] > a[largest]) {
            largest = left;
        }
        if (right < heapSize && a[right] > a[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            heapify(a, largest, heapSize);
        }
    }

    static void buildMaxHeap(int[] a) {
        int n = a.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(a, i, n);
        }
    }

    static void heapSort(int[] a) {
        buildMaxHeap(a);
        for (int end = a.length - 1; end >= 1; end--) {
            int temp = a[0];
            a[0] = a[end];
            a[end] = temp;
            heapify(a, 0, end);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 2, 3, 4, 7, 10, 6, 7, 2, 1};
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }
}