package 강송이하홍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj18258 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new LinkedList<Integer>();
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch (command) {
			case "push":
				deque.add(Integer.parseInt(st.nextToken()));
				break;
				
			case "pop":
				if(deque.isEmpty())
					sb.append(-1);
				else
					sb.append(deque.pop());
				sb.append('\n');
				break;
				
			case "size":
				sb.append(deque.size()).append('\n');
				break;
				
			case "empty":
				if(deque.isEmpty())
					sb.append(1);
				else
					sb.append(0);
				sb.append('\n');
				break;
				
			case "front":
				if(deque.isEmpty())
					sb.append(-1);
				else
					sb.append(deque.peekFirst());
				sb.append('\n');
				break;
				
			case "back":
				if(deque.isEmpty())
					sb.append(-1);
				else
					sb.append(deque.peekLast());
				sb.append('\n');
				break;
			}
		}
		System.out.println(sb);
	}
}
