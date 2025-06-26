package 강송이하홍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj15591 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		LinkedList<int[]>[] usado = new LinkedList[N+1];
		for(int r = 1; r <= N; r++) {
			usado[r] = new LinkedList<int[]>();
		}
		
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			usado[p].add(new int[] {q, r});
			usado[q].add(new int[] {p, r});
		}
		
		Queue<int[]> q = new LinkedList<int[]>();
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());			
			boolean[] visited = new boolean[N+1];
			visited[v] = true;
			int cnt = 0;
			q.add(new int[] {1000000001, v});
			while(!q.isEmpty()) {
				int[] curr = q.poll();
				for(int[] nxt : usado[curr[1]]) {
					if(visited[nxt[0]]) continue;
					int nxtUsado = nxt[1];
					if(nxtUsado == Integer.MAX_VALUE) continue;
					int minimum = Math.min(curr[0], nxtUsado);
					if(minimum >= k) {
						cnt++;
						q.add(new int[] {minimum, nxt[0]});
						visited[nxt[0]] = true;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
