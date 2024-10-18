package problems.array;

import java.util.*;

public class Main{

    public static int minNumber(int[][] arr){
        Arrays.sort(arr, (int[] a, int[] b)->(a[0]-b[0]));
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.offer(arr[0][1]);
        for (int i=0;i<arr.length;i++){
            if(q.peek()<=arr[i][0]){
                q.poll();
            }
            q.offer(arr[i][1]);
        }
        return q.size();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String raw = in.nextLine();
        raw = raw.trim();
        raw = raw.substring(2,raw.length()-2);
        String[] rows = raw.split("\\],\\[");
        int R = rows.length;
        int[][] arr = new int[R][2];
        for(int i=0;i<R;i++){
            String[] two = rows[i].replaceAll("[\\[\\]]","").split(",");
            arr[i][0]=Integer.parseInt(two[0].trim());
            arr[i][1]=Integer.parseInt(two[1].trim());
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(minNumber(arr));
    }
}