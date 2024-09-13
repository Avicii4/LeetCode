package exam;

import java.util.HashSet;
import java.util.Set;

public class Tuhu3 {
    /**
     * 路径最优规划
     *
     * @param cityNumber int整型 城市数量
     * @param roadNumber int整型 道路条数
     * @param roadArray  int整型二维数组 城市之间联通定义
     * @return int整型
     */
    public int roadPlan(int cityNumber, int roadNumber, int[][] roadArray) {
        UnionFind uf = new UnionFind(cityNumber);
        for (int[] road : roadArray) {
            uf.union(road[0], road[1]);
        }
        Set<Integer> chunks = new HashSet<>();
        for (int i = 0; i < cityNumber; i++) {
            chunks.add(uf.find(i));
        }
        return chunks.size()-1;
    }


    class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size + 1];
            rank = new int[size + 1];
            for (int i = 1; i <= size; i++) {
                parent[i] = i;  // 开始时自成一个集合
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                if (rank[px] > rank[py]) {
                    parent[py] = px;
                } else if (rank[px] > rank[py]) {
                    parent[px] = py;
                } else {
                    parent[py] = px;
                    rank[px]++;
                }
            }
        }


    }
}
