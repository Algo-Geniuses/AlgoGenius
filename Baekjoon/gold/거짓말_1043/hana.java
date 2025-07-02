import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int n, m; // 사람 수, 파티 수
	static int[] parent; // 유니온 파인드용 1차원 배열
	static List<Integer>[] parties; // 각 파티마다 오는 사람들 저장용 리스트
	static int[] truthPeople; //진실 아는 사람들

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
            parent[i] = i; // 유니온파인드 초기화 -> 일단 자기자신이 대표
        }

		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken()); 
		truthPeople = new int[t];
		for (int i = 0; i < t; i++) {
			truthPeople[i] = Integer.parseInt(st.nextToken());  // 진실을 알고 있는 사람들 번호 저장
		}

		parties = new ArrayList[m]; // 각 파티 참여자들 저장
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken()); // 파티 인원 수
			parties[i] = new ArrayList<>();

			for (int j = 0; j < size; j++) {
				parties[i].add(Integer.parseInt(st.nextToken()));
			}
			// 파티 나온 사람들 하나의 그룹으로 유니온
			for (int j = 1; j < parties[i].size(); j++) {
				union(parties[i].get(0), parties[i].get(j));
			}
		}

		int count = 0;
		for (int i = 0; i < m; i++) {
			boolean canLie = true;
			int leader = find(parties[i].get(0));

			for (int tp : truthPeople) { //현재 파티와 진실을 아는 사람이 같은 그룹? -> 거짓말 못함
				if (find(tp) == leader) {
					canLie = false;
					break;
				}
			}
			if (canLie) count++; // 진실 아는 사람과 연결X -> 거짓말 가능
		}

		System.out.println(count);
	}

	static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}

	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa != pb) parent[pb] = pa;
	}
}
