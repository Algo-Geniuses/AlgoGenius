package Baekjoon.gold.MooTube;

// 문제 정리
/*
1. N까지의 영상이 존재
2. 영상끼리 가는 경로는 무조건 존재하며, 개수는 N-1 개이다.
=> 유니온 파인드

N ( 1 <= N <= 5,000)
Q (1 ≤ Q ≤ 5,000)
ki (1 ≤ ki ≤ 1,000,000,000)
vi (1 ≤ vi ≤ N)

 */
//----------------------------- 풀이 방법 -----------------------------//
// 1. 오프라인 쿼리
// 2. 유니온파인드

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 우석 {
    static int[] parent;    // 각 노드의 부모 노드를 저장하는 배열
    static int[] size;      // 각 집합의 크기를 저장하는 배열

    // 동연상 간 연결 정보를 저장하는 클래스 -> 간선 정보
    static class Edge {
        int u, v, usado;
        Edge(int u, int v, int usado) {
            this.u = u;
            this.v = v;
            this.usado = usado;
        }
    }


    // 질문 정보를 저장하는 클래스
    static class Query {
        int k, v, idx;    //최소 유사도, 시작 동영상 번호, 질문 순서
        Query(int k, int v, int idx) {
            this.k = k;
            this.v = v;
            this.idx = idx;
        }
    }

    // 유니온 파인드 : 두 그룹을 합치는 함수
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;

        //항상 큰 그룸에 작은 그룹 합치기
        if (size[a] < size[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        parent[b] = a;
        size[a] += size[b];
    }


    // 유니온 파인드 : 대표 노드를 찾는 함수
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

        //간선 정보 리스트 생성
        List<Edge> edges = new ArrayList<>();

        //N-1 개의 정보 받기
        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            edges.add(new Edge(p, q, r));
        }

        // 질문 정보를 저장할 배열
        Query[] queries = new Query[Q];
        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());   //최소 유사도
            int v = Integer.parseInt(st.nextToken());   //시작 동영상 번호
            queries[i] = new Query(k, v, i);
        }

        //간선들의 유사도 내림차순으로 정렬
        edges.sort((a, b) -> b.usado - a.usado);

        //질문도 유사도 기준으로 내림차순 정렬
        Arrays.sort(queries, (a, b) -> b.k- a.k);

        //유니온 파인드 초기화
        parent = new int[N + 1];
        size = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int[] ans = new int[Q];
        int edgeIdx = 0;        //간선을 처리할 인덱스


        // 각 질문을 통한 정답 구하기
        for (Query query : queries) {
            // 현재 질문의 K 이상인 산선을 유니온으로 연결
            while (edgeIdx < edges.size() && edges.get(edgeIdx).usado >= query.k) {
                union(edges.get(edgeIdx).u, edges.get(edgeIdx).v);
                edgeIdx++;
            }


            // 현재 시작 동영상 v가 속한 그룹의 크기 -1이 정답 <- 자기 자신은 제외하므로
            ans[query.idx] = size[find(query.v)] - 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int a : ans) {
            sb.append(a).append("\n");
        }
        System.out.println(sb);
    }

}
