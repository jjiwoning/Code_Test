package algo_sample_code;

public class BinarySearchSample {

    public static void main(String[] args) {
        int[] data = {1, 3, 4, 5, 5, 5, 7, 10};

        System.out.println(binarySearch(data, 4));
        System.out.println(binarySearchLowerBound(data, 5));
        System.out.println(binarySearchUpperBound(data, 5));
    }

    private static int binarySearch(int[] data, int target) {
        int start = 0;
        int end = data.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (data[mid] > target) {
                end = mid - 1;
            }
            if (data[mid] < target) {
                start = mid + 1;
            }
            if (target == data[mid]) {
                return mid;
            }
        }

        return -1;
    }

    private static int binarySearchLowerBound(int[] data, int target) {
        int start = 0;
        int end = data.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (data[mid] >= target) {
                end = mid;
            }
            if (data[mid] < target) {
                start = mid + 1;
            }
        }

        return end;
    }

    private static int binarySearchUpperBound(int[] data, int target) {
        int start = 0;
        int end = data.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (data[mid] > target) {
                end = mid;
            }
            if (data[mid] <= target) {
                start = mid + 1;
            }
        }

        return end;
    }
}
