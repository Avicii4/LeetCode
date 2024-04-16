package exam;

import java.util.*;

/**
 * 小红发布了n个笔记，每个笔记的点赞数为a。
 * 小红观察到，每隔一段时间，某个笔记的点赞数就会加1，但是不会出现一个笔记点赞数连续增加的情况。
 * 也就是说，一个笔记赞数加1,下一个加1的必然是另一个笔记。
 * 现在小红想知道，对于每一个笔记，其赞数变成所有笔记赞数最多时，此时所有的笔记赞数之后，和的最小值是多少。
 *
 * 输入是笔记数n 和各笔记当前的赞数
 *
 *
 */
public class MinLikesSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr = new long[n];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        List<Long> res = new ArrayList<>();
        if (n == 1) {
            res.add(arr[0]);
        }
        if (n == 2) {
            long min = Math.min(arr[0], arr[1]);
            long max = Math.max(arr[0], arr[1]);

            if (max - min <= 1) {
                if (arr[0] > arr[1]) {
                    res.add(arr[0] + arr[1]);
                    res.add(arr[0] + arr[1] + 1);
                } else if (arr[0] == arr[1]) {
                    res.add(arr[0] + arr[1]);
                    res.add(arr[0] + arr[1]);
                } else {
                    res.add(arr[0] + arr[1] + 1);
                    res.add(arr[0] + arr[1]);
                }

            } else {
                if (arr[0] > arr[1]) {
                    res.add(arr[0] + arr[1]);
                    res.add(-1L);
                } else {
                    res.add(-1L);
                    res.add(arr[0] + arr[1]);
                }
            }
        }

        if (n >= 3) {
            long max = arr[0];
            long min = arr[0];
            for (long num : arr) {
                if (num > max) {
                    max = num;
                }
                if (num < min) {
                    min = num;
                }
            }
            long arrSum = Arrays.stream(arr).sum();
            for (long num : arr) {
                if (num == max) {
                    res.add(arrSum);
                } else if (num == min) {
                    // 如果是最小赞数的笔记
                    res.add(getTimes(arr,num));
                } else {
                    long val = arrSum + (max - num)+(max - num-1);
                    res.add(val);
                }
            }

        }
        for (long num : res) {
            System.out.println(num);
        }
    }

    /**
     * 想法是除了最小值minValue，其他元素维护一个优先队列，
     * 先给minValue++，然后优先队列弹出最小值给它+1再回队列里
     * 并且每次比较minValue是不是已经等于队列里的最大值了
     */
    private static long getTimes(long[] arr, long minValue) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long num : arr) {
            if (num != minValue) {
                pq.add(num);
            }
        }
        long res = 0L;
        long curMax = Collections.max(new ArrayList<>(pq));
        int flag = 0;
        while (minValue < curMax) {
            if (flag % 2 == 0) {
                minValue++;
            } else {
                long pqMinValue = pq.poll();
                pqMinValue++;
                pq.add(pqMinValue);
                curMax = Collections.max(new ArrayList<>(pq));
            }
            flag++;
        }
        for (long num : pq) {
            res += num;
        }
        return res + minValue;
    }
}
