package Baekjoon.gold.MooTube;
// 문제 정리
/*
1. N까지의 영상이 존재
2. 영상끼리 가는 경로는 무조건 존재하며, 개수는 N-1 개이다.
=> 가중치가 있는 BFS???

N ( 1 <= N <= 5,000)
Q (1 ≤ Q ≤ 5,000)
ki (1 ≤ ki ≤ 1,000,000,000)
vi (1 ≤ vi ≤ N)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class wooseok {

    static int[] parent;
    static int[] size;

    static class Edge {
        int u, v, usado;
        Edge(int u, int v, int usado) {
            this.u = u;
            this.v = v;
            this.usado = usado;
        }
    }


    static class Query {
        int k, v, idx;
        Query(int k, int v, int idx) {
            this.k = k;
            this.v = v;
            this.idx = idx;
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;

        if (size[a] < size[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        parent[b] = a;
        size[a] += size[b];
    }

    static int find(int x) {
        if(parent[x] != x){ parent[x] = find(parent[x]);}
        return parent[x];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            edges.add(new Edge(p, q, r));
        }

        Query[] queries = new Query[Q];
        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            queries[i] = new Query(k, v, i);
        }

        edges.sort((a, b) -> b.usado - a.usado);

        Arrays.sort(queries, (a, b) -> b.v - a.v);

        parent = new int[N + 1];
        size = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int[] ans = new int[Q];
        int edgeIdx = 0;

        for(Query query : queries) {
            while (edgeIdx < edges.size() && edges.get(edgeIdx).usado >= query.k) {
                union(edges.get(edgeIdx).u, edges.get(edgeIdx).v);
                edgeIdx++;
            }

            ans[query.idx] = size[find(query.v)] - 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int a : ans) {
            sb.append(a).append("\n");
        }
        System.out.println(sb);
    }

}
