import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int T;
	

	static StringBuilder sb = new StringBuilder();


	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		Stack<Integer> stk = new Stack<>();
		
		for(int i = 0 ; i < T ;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String command = st.nextToken();
			
			if(st.hasMoreTokens()) {
				stk.push(Integer.parseInt(st.nextToken()));
			} else if(command.equals("pop")) {
				if(stk.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(stk.pop()).append("\n");
			} else if(command.equals("size")) {
				sb.append(stk.size()).append("\n");
			} else if(command.equals("empty")) {
				if(stk.isEmpty())
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
			} else if(command.equals("top")) {
				if(stk.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(stk.peek()).append("\n");
			}
		}
	
		System.out.println(sb);

		}
	
	
}