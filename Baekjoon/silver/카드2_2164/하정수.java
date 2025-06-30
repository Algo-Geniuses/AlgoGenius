package 강송이하홍;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1; i <= N; i++) {
			q.add(i);
		}
		while(q.size() != 1) {
			q.poll();
			q.add(q.poll());
		}
		System.out.println(q.poll());
	}
}
