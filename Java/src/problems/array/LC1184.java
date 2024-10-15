package problems.array;

public class LC1184 {
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sumA = 0, sumB = 0;
        int a = Math.min(start, destination);
        int b = Math.max(start, destination);
        for (int i = a; i < b; i++) {
            sumA += distance[i];
        }
        for (int i = 0; i < a; i++) {
            sumB += distance[i];
        }
        for (int i = b; i < distance.length; i++) {
            sumB += distance[i];
        }
        return Math.min(sumA, sumB);
    }

    public static void main(String[] args) {
        int[] dis = {10, 2, 3, 4};
        System.out.println(distanceBetweenBusStops(dis, 0, 1));
    }
}
