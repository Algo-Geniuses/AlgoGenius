package 강송이하홍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class bj1918 {
	public static void main(String[] args) throws IOException {
		Map<Character, Integer> priority = new HashMap<>();
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('(', 0);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String fomular = br.readLine();
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < fomular.length(); i++) {
			char curr = fomular.charAt(i);
			if(65 <= curr && curr <= 90) {
				sb.append(curr);
			}
			else if(stack.isEmpty()) {
				stack.add(curr);
			}
			else if(curr == '(') {
				stack.add(curr);
			}
			else if(curr == ')') {
				while(stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
			}
			else {
				while(!stack.isEmpty() && priority.get(curr) <= priority.get(stack.peek())) {
					sb.append(stack.pop());
				}
				stack.add(curr);
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}
}
