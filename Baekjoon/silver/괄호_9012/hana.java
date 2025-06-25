import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCases = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCases; i++) {
			char[] chars = br.readLine().toCharArray();
			int balance = 0;
			boolean isValid = true;

			for (char c : chars) {
				if (c == '(') {
					balance++;
				} else if (c == ')') {
					balance--;
				}
				if (balance < 0) { 
					isValid = false;
					break;
				}
			}

			if (isValid && balance == 0) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}

		System.out.print(sb);
	}
}
