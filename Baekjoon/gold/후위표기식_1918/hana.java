import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	static StringBuilder sb = new StringBuilder();

	static int getPriority(char op) {
		if (op == '+' || op == '-') return 1;
		else if (op == '*' || op == '/') return 2;
		else return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < input.length(); i++) {
			char token = input.charAt(i);

			if (token >= 'A' && token <= 'Z') {
				sb.append(token);
			} else if (token == '(') {
				stack.push(token);
			} else if (token == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
			} else {
				while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(token)) {
					sb.append(stack.pop());
				}
				stack.push(token);
			}
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		System.out.print(sb);
	}
}
