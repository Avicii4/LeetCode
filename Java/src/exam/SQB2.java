package exam;

import java.util.*;

public class SQB2 {

    public static int maxPeople(List<int[]> lst, int maxStation) {
        boolean[] visited = new boolean[maxStation + 1];
        return process(lst, visited, 0);
    }

    private static int process(List<int[]> lst, boolean[] visited, int idx) {
        // 边界条件
        if (idx >= lst.size()) {
            return 0;
        }

        int[] area = lst.get(idx);
        if (visited[area[0]] || visited[area[1]]) {
            return process(lst, visited, idx + 1);
        }
        // 要当前idx的区间
        for (int i = area[0]; i <= area[1]; i++) {
            visited[i] = true;
        }
        int m = process(lst, visited, idx + 1) + 1;
        for (int i = area[0]; i <= area[1]; i++) {
            visited[i] = false;
        }
        // 不要当前idx区间
        int n = process(lst, visited, idx + 1);
        return Math.max(m, n);
    }

    public static int maxPeople_2(List<int[]> lst, int maxStation) {
        int curStation = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] area : lst) {
            if (map.containsKey(area[0])) {
                if (area[1] < map.get(area[0])) {
                    map.put(area[0], area[1]);
                }
            } else {
                map.put(area[0], area[1]);
            }
        }
        lst.clear();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int l = entry.getKey();
            int r = entry.getValue();
            lst.add(new int[]{l, r});
        }
        lst.sort(Comparator.comparingInt(o -> o[0]));
        Map<Integer, Integer> twoMap = new HashMap<>();
        for (int[] area : lst) {
            if (twoMap.containsKey(area[1])) {
                if (area[0] > twoMap.get(area[1])) {
                    twoMap.put(area[1], area[0]);
                }
            } else {
                twoMap.put(area[1], area[0]);
            }
        }
        lst.clear();
        for (Map.Entry<Integer, Integer> entry : twoMap.entrySet()) {
            int r = entry.getKey();
            int l = entry.getValue();
            lst.add(new int[]{l, r});
        }


        for (int[] area : lst) {
            if (area[0] > curStation) {
                res++;
                curStation = area[1];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<int[]> lst = new ArrayList<>();
        int maxStation = 0;
        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            maxStation = Math.max(maxStation, r);
            lst.add(new int[]{l, r});
        }
        System.out.println(maxPeople(lst, maxStation));
    }
}
