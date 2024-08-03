package exam;

public class Zhl {
    public static int find(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = right - (right - left) / 2;
            if (((mid - 1 >= 0 && arr[mid] != arr[mid - 1]) &&
                    (mid < arr.length && arr[mid] != arr[mid + 1]))) {
                return arr[mid];
            } else if (arr[mid] == arr[mid - 1]) {
                if (((mid - left) & 1) == 1) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else if (arr[mid] == arr[mid + 1]) {
                if (((right - mid) & 1) == 1) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
        }
        return arr[left];
    }

    public static void main(String[] args) {
        int[] arr = {1};
        //int[] arr = {9, 9, 8, 7, 7, 6, 6};
        System.out.println(find(arr));
    }
}
