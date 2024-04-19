package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class Graph {
    public HashSet<Edge> edges;          //图中的边
    public HashMap<Integer, Node> nodes;  //图中的节点

    public Graph() {
        edges = new HashSet<>();
        nodes = new HashMap<>();
    }
}


class Node {
    public int value;//结点的值
    public int in;   //该节点的入度
    public int out;  //该节点的出度
    public ArrayList<Node> nexts;  //该节点指向的那些节点
    public ArrayList<Edge> edges;  //以该节点为初始 发出去的那些边

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}

class Edge {
    public int weight;  //边的权重
    public Node from;   //边的两头的节点 一个from 一个to
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}


