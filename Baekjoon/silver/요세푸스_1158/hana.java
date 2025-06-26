import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); 
		int k = Integer.parseInt(st.nextToken()); 

		Queue<Integer> circle = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			circle.offer(i);
		}

		sb.append('<');
		int cursor = 1;

		while (!circle.isEmpty()) {
			if (cursor == k) {                 
				sb.append(circle.poll());
				if (!circle.isEmpty()) sb.append(", ");
				cursor = 1;                  
			} else {                           
				circle.offer(circle.poll());
				cursor++;
			}
		}

		sb.append('>');
		System.out.print(sb);
	}
}
